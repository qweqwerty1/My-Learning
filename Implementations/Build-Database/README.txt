https://imsoo.github.io/2020-01-01/LBASD-PART1

제1장 - 소개 및 REPL 구축

프로젝트 개요 : 데이터베이스의 작동원리 이해
- 데이터의 저장 형식(메모리와 디스크)
- 언제 메모리에서 디스크로 옮겨지는가
- 왜 테이블마다 하나의 주키만을 가질 수 있는가
- 어떻게 트랜잭션 롤백이 수행되는가?
- 전체 테이블 탐색 작업은 언제, 어떻게 수행되는가?
- 준비된 문장은 어떠한 형식으로 저장되는가?

*getline은 POSIX 표준으로 윈도우에서 기본 제공하지 않아 별도로 구현해야함
- 허나, 기본기 숙련 및 해당 함수의 정확한 기능을 알기 위해 본 코드에서는 직접구현 하고자 함

[getline]
1. 함수 및 원소(인자) 개요
 - 형식 : ssize_t
  size_t에서 음수가 가능한 형태(8바이트)
  ㄱ. 음수가 왜 필요한가? EOF 시 -1를 반환하여 해당 함수가 실패 했다고 알림이 필요하기 때문
  ㄴ. 0은 일반적으로 성공값이나 본 함수에선 pos를 반환하여 성공적으로 입력받은 데이터의 개수
  ㄷ. size_t를 왜 쓰는가?
    - 32비트 컴퓨터와 64비트 컴퓨터 즉 사용자의 환경에 대응할 수 있는 형태(cast)이기 때문 long의 경우 윈도우와 리눅스에서 바이트가 다르다.
      해당 내용은 "데이터 모델(Data Model)의 차이 이며 Windows와 Linux/Unix의 모델이 LLP64/LP64로 long에서 바이트 차이가 나므로
      size_t,ssize_t의 경우 최대 주소 지정 가능 크기를 담도록 설계되었으므로 메모리 사이즈나 배열 인덱스를 다룰때에는 size_t를 써야한다.

 - 함수의 인자에 대하여
  char** lineptr은 문자열 포인터 배열의 포인터 개념이 아닌, line이 size를 초과 했을 때 realloc한 공간으로 lineptr 문자열의 주소 "값"을 변경하기 위한 이중 포인터이다.
  size_t 또한 본 함수에서 값을 받게되면, 함수 종료 이후 스택메모리가 비워짐에 따라 사라지게 되므로 원 구조체의 메모리주소에 접근하여 직접 값을 수정하기 위해 포인터를 받는다.
  FILE * 은 스트림 추상화로서 단순 파일을 넘어선 입력 스트림(Input Stream)의 추상화이며, 물리적 파일, 표준 입력(stdin), 파이프(pipe), 소켓 등을 모두 동일한 방식으로 처리 할 수 있게한다.
  (Unix 철학: Everything is a file!)

2. 지역변수 pos 및 c /* size_t pos = 0; int c; */
 - pos
  ㄱ. pos는 lineptr의 index의 개념으로 사용될 수 있다. 즉 pos + 1(널문자)가 n과 같다면(혹은 크다면) lineptr을 realloc하여 크기를 확장시켜야 한다.
  ㄴ. pos는 또한 본 getline함수의 return 값이다. 마지막 널문자('\0')의 위치, 즉 실제 널문자를 제외한 데이터의 개수와 일치하며 이는 strlen과 동일하다.
     단, getline은 '\n' 즉 개행 문자 까지 포함하여 길이를 세므로 이를 유의하여야 한다(REPL 구축에서도 개행문자 처리가 별도로 있음) 
  ㄷ. C 언어의 함수는 실패 -1, 성공 0(True or False 일 경우), 성공(데이터 반환 값) n 으로 출력하는 권장 규칙이 있으므로 본 함수도 이 규칙을 따른다.
 - c
  ㄱ. c는 stream으로 입력받을 값, 즉 문자열 에서 character단위로 분해해 저장할 때 사용할 변수이다.
  ㄴ. c가 char가 아닌 이유는, 입력이 끝난 즉 EOF 상태일 때 -1을 담아야 하므로, 음수까지 커버 가능한 int를 사용하는 것이다.

3. buffer == NULL의 처리
/* if (*lineptr == NULL) {
	*lineptr = (char*)malloc(128);
	*n = 128;
} */

 - Input_Buffer -> buffer = NULL 일 경우 RAM에 힙공간을 생성하여야 한다.(지연 할당)
 * 초기 값이 128인 이유
  ㄱ. Allocator Friendliness: 메모리 할당자(glibc malloc 등)는 주로 2의 제곱수 단위(Chunk)로 메모리를 관리한다. 128은 내부 단편화(Internal Fragmentation)를 최소화 하는 효율적인 단위다.
  ㄴ. Heuristic (경험적 수치) : 일반적인 콘솔 입력 한 줄(약 80자)을 realloc 없이 한번에 담을 수 있는 적절한 크기다. 
 - n의 역참조를 통해 값을 변경하여 해당 구조체의 주소로 직접 접근해 본 함수가 끝나더라도 변경 될 수 있도록 한다.

4. Stream 처리(getline의 실 구현)
/* while((c = getc(stream)) != EOF) {
    if (pos + 1 >= *n) {
      size_t new_len = *n + (*n >> 2);
      if (new_len < 128) new_len = 128;
      char *new_ptr = (char*)realloc(*lineptr, new_len);
      if (new_ptr == NULL) return -1;
      *n = new_len;
      *lineptr = new_ptr;
    }
    ((char*)*lineptr)[pos++] = c;
    if (c == '\n') break;
    ... 이어서
}

 - getc(stream)
  이 함수 내에서 가장 많이 반복될 구절로 fgetc 대신 getc를 사용한다.
  ㄱ. getc 의 사용 이유? getc는 매크로이므로 반복이 가장 많은 구절에서 사용하여 효율을 상승시키기 위함
  ㄴ. stream에서 받아올 것이 더이상 없다면(EOF) c = -1 이다. 즉 c는 음수를 포함할 수 있는 형태가 필요(int)
 - pos + 1 >= *n
  lineptr은 문자열의 배열이므로 마지막에는 항상 널문자('\0')가 들어가야 한다. 
  따라서 현재 인덱스 + 1 보다 크거나 같으면 힙공간을 확장 시켜야 한다.
 - 힙 공간의 확장 new_len
  ㄱ. 문자열의 길이가 현재 힙공간과 같아지면(또는 커지면) 기존 공간보다 큰 공간을 빌려야 한다.
  ㄴ. 상기 *lineptr = NULL 일때 최소값 128의 공간을 확보 했으므로 new_len 또한 128이 최소값
  ㄷ. 메모리파편화 방지를 위해 확장 시 1.25배 증가 로직 채용
   - 적은 값에서 잦은 realloc 사용 방지를 위한 128 최소값 확보 완료
  ㄹ. *lineptr의 메모리 누수 방지를 위해 *new_ptr 포인터를 만들고 realloc을 수행한다
   - realloc 실패 시 NULL을 반환하는데, 기존 *lineptr의 데이터를 유실할 수 있음
 - ((char*)*lineptr)[pos++] = c
  ㄱ. 명시적으로 char*을 표현하여 lineptr이 char*형식임을 알려준다.
  ㄴ. 현재 index(pos)에 c 값을 넣고 +1을 한다.
 - if(c == '\n') break;
  getc()가 문자열 뿐만 아니라 개행문자 까지 인자로 받으므로, 개행문자를 입력받으면 루프 탈출

/* ...이어서
if (c == EOF && pos == 0) return -1;
((char*)*lineptr)[pos] = '\0'
return pos;
*/

 - c = EOF and pos = 0
  아무 입력값이 없는 상태로 해당 상태는 실패(-1) 처리
 - '\0'
  이전에 pos++를 하면서 현재 pos의 위치가 문자열 끝 + 1 인덱스이므로 마침표(널문자)입력

[InputBuffer]
/* 
 typedef struct {
    char* buffer;
    size_t buffer_length;
    ssize_t input_length;
} InputBuffer;

InputBuffer* new_input_buffer() {
    InputBuffer* input_buffer = (InputBuffer*)malloc(sizeof(InputBuffer));
    input_buffer->buffer = NULL;
    input_buffer->buffer_length = 0;
    input_buffer->input_length = 0;

    return input_buffer;
}

void close_input_buffer(InputBuffer* input_buffer) {
    free(input_buffer->buffer);
    free(input_buffer);
}
*/

 - InputBuffer
  getline의 FILE을 받을 구조체이다.
   ㄱ. 버퍼에 담긴 내용(buffer)
   ㄴ. 버퍼의 최대 크기(buffer_length/capacity)
   ㄷ. 현재 입력(FILE)값의 크기(input_length/size)
  input_length >= buffer_length가 된다면 getline 함수에 의해 크기가 확장될 것이다.
   * 구조체의 설계 의도 : 관련된 데이터(문자열 포인터, 버퍼 크기, 입력 길이)를 하나의 sturct로 묶어
     응집도를 높이고 관리의 편의성을 도모함
  input_length는 getline 함수가 실패시 -1을 반환하므로(input_length가 getline 함수 return 값)
  ssize_t를 사용한다.
 - new_input_buffer
  상기 구조체의 생성자를 담당하는 역할로 입력값을 별도로 받지 않고 NULL과 0으로 초기화한다
   * 이는 지연 할당을 위해서이며, 쓰지 않는 불필요한 공간을 만들지 않기 위함이다.
 - close_input_buffer
  구조체의 free선언으로, 구조체 내부에 존재하는 포인터부터 free를 하고 마지막에 포인터와
  크기 값을 가진 struct를 free하여야 메모리 누수(memory leak)가 없다.
   * struct를 먼저 free하게 되면, buffer가 가르키는 문자열의 주소는 영원히 찾을 수 없다.
     즉 buffer를 먼저 free선언하고 struct구조체를 free해야 한다.

[read_input]
/* 
void read_input(InputBuffer* input_buffer) {
    ssize_t bytes_read = getline(&(input_buffer->buffer), &(input_buffer->buffer_length), stdin);

    if (bytes_read <= 0) {
        printf("Error reading input\n");
        exit(EXIT_FAILURE);
    }

    // 후행 줄 바꿈 제거
    input_buffer->input_length = bytes_read - 1;
    input_buffer->buffer[bytes_read - 1] = 0;
}
*/

- bytes_read
  getline의 return값, 성공적으로 입력된 값의 개수이며 이 개수에는 개행문자가 포함되어 있다.
- if (bytes_read <= 0)
  bytes_read가 -1 일 때, 즉 getline 함수가 정상적으로 종료되지 못했을 때이다.
  이 경우 에러메세지를 출력하고, 프로그램을 종료한다.
- 후행 줄 바꿈 제거
  getline 함수는 키보드 입력값에 개행문자('\n')을 포함하므로 해당 문자를 없애주어야 한다.
  따라서 input_length의 길이를 -1 해주고, 마지막 인덱스('\0')의 전 인덱스로 접근해 널문자 처리한다.

[main]
/*
int main(int argc, char* argv[]) {
    InputBuffer* input_buffer = new_input_buffer();
    while (true) {
        print_prompt();
        read_input(input_buffer);

        if (strcmp(input_buffer->buffer, ".exit") == 0) {
            close_input_buffer(input_buffer);
            exit(EXIT_SUCCESS);
        } else {
            printf("Unrecognized command '%s'.\n", input_buffer->buffer);
        }
    }
}
*/

 - 메인 함수에서 InputBuffer 구조체를 생성한다.
 - strcmp로 buffer의 문자가 .exit 이면 프로그램을 종료 시킨다.
 - 현재는 다른 DB 명령어가 미 구현되어 있으므로 나머지 경우에는 알 수 없는 명령어 처리한다.

@ 참고사항
  * 메인함수의 구조를 통해 input_buffer의 속성을 알 수 있다.
   - buffer_length를 할당 받게 되면, 매번 반복하여 input_buffer가 buffer_length 보다 작을 때 
    기존 메모리공간을 재사용 한다.
   - buffer_length가 커지게 되면 상기 개념(재사용) 때문에 불필요한 힙 공간 점유가 생길 수 있다.
    * 단, 진행중인 프로젝트 Build-Database의 경우 REPL(대화형 쉘) 특성상 성능 이점이 더 큼


https://imsoo.github.io/2020-01-02/LBASD-PART2

제2장 - 세상에서 가장 간단한 SQL 컴파일러 및 가상 머신

https://imsoo.github.io/assets/images/LBASD/arch2.gif

- sqlite의 전단 부는 문자열을 구문 분석하여 내부 표현 형태인 바이트코드로 출력하는 SQL 컴파일러입니다.
- 위 바이트 코드는 가상 머신으로 전달되고, 가상 머신은 바이트코드를 실행합니다.

두 단계로 나누는 것은 두 가지 이점이 있다
1. 각 부분의 복잡성을 낮추게 된다.(예: 가상머신은 구문 오류를 고려하지 않아도 됩니다.)
2. 자주 쓰이는 쿼리를 컴파일하고 바이트코드를 캐싱하여 성능을 향상시킬 수 있다.

[상태정의(열거형) + 데이터 컨테이너]
/* typedef enum {
    META_COMMAND_SUCCESS,
    META_COMMAND_UNRECOGNIZED_COMMAND
} MetaCommandResult;

typedef enum { PREPARE_SUCCESS, PREPARE_UNRECOGNIZED_STATEMENT } PrepareResult;

typedef enum { STATEMENT_INSERT, STATEMENT_SELECT } StatementType;

typedef struct {
    StatementType type;
} Statement;
*/

 - 메타 명령(점으로 시작하는 명령)의 검사, 준비된 문장(PREPARE)의 검사, 상태(STATEMENT)의 구분
  * 검사는 실패 or 성공이므로 0과 1로 구분, 상태는 현재 2가지 이지만 추가 될 수 있음
 - Statement(struct)를 통해 현재 Statement(insert, select 등)와 각종 필요 데이터들 저장(2장에서는 type만 저장)
 - enum은 첫번째 인자를 0부터 추가될 때마다 auto_incresement되는 형태이다.
  * 해당 형식을 사용함으로서 switch문을 응용하여 버퍼내용의 검사를 수월하게 할 수 있다.

[문장의 실처리]
/* MetaCommandResult do_meta_command(InputBuffer* input_buffer) {
    if(strcmp(input_buffer->buffer, ".exit") == 0) {
        close_input_buffer(input_buffer);
        exit(EXIT_SUCCESS);
    } else {
        return META_COMMAND_UNRECOGNIZED_COMMAND;
    }
}

PrepareResult prepare_statement(InputBuffer* input_buffer, Statement* statement){
    if (strncmp(input_buffer->buffer, "insert",6) == 0) {
        statement->type = STATEMENT_INSERT;
        return PREPARE_SUCCESS;
    }
    if (strcmp(input_buffer->buffer,"select") == 0){
        statement->type = STATEMENT_SELECT;
        return PREPARE_SUCCESS;
    }

    return PREPARE_UNRECOGNIZED_STATEMENT;
}

void execute_statement(Statement* statement){
    switch (statement->type) {
        case (STATEMENT_INSERT):
            printf("This is where we would do an insert.\n");
            break;
        case (STATEMENT_SELECT):
            printf("This is where we would do a select.\n");
            break;
    }
}
*/

 - 메타커맨드(.)를 입력받으면 do_meta_command함수를 통해 적합한 명령어(ex: ".exit")인지 검사 후 해당 명령을 수행, 또는 상태(실패) 반환
 - 명령어를 입력받으면 prepare_statement를 통해 적합한 명령어인지 검사 후 상태(type)와 Prepare 성공여부를 반환
 - prepare(프론트엔드)를 통해 검사를 하고 excute를 통해 실제 결과물을 만듬(현재는 간단한 성공 문자만 출력한다.)

[main]
/*
-    if (strcmp(input_buffer->buffer, ".exit") == 0) {
-      close_input_buffer(input_buffer);
-      exit(EXIT_SUCCESS);
-    } else {
-      printf("Unrecognized command '%s'.\n", input_buffer->buffer);

+    if (input_buffer->buffer[0] == '.') {
+      switch (do_meta_command(input_buffer)) {
+        case (META_COMMAND_SUCCESS):
+          continue;
+        case (META_COMMAND_UNRECOGNIZED_COMMAND):
+          printf("Unrecognized command '%s'\n", input_buffer->buffer);
+          continue;
+      }
     }
+
+    Statement statement;
+    switch (prepare_statement(input_buffer, &statement)) {
+      case (PREPARE_SUCCESS):
+        break;
+      case (PREPARE_UNRECOGNIZED_STATEMENT):
+        printf("Unrecognized keyword at start of '%s'.\n",
+               input_buffer->buffer);
+        continue;
+    }
+
+    execute_statement(&statement);
+    printf("Executed.\n");
*/

 - 기존 .exit를 입력받으면 종료되는 것을 buffer[0] == '.'일 때 do_meta_command함수를 통해 종료되도록 변경
 - 또한 prepare_statement를 통해 적합한 명령어(메타 커맨드가 아닐 때)인지 검사 후 성공하면 타입(StatementType) 저장 후 
  execute_statement(실 수행 함수)를 실행한다. 

  @참고사항
   * switch는 분기문(Branch)이다. 
    - break : switch문을 탈출하거나, 반복문을 탈출한다.(가장 가까운 녀석/스택)
    - continue : switch문은 이 명령어를 처리할 능력이 없다. 그래서 가장 가까운 반복문에게 신호가 토스된다.
    main함수에서 사용된 용법을 보면 위 내용이 이해가 될 것이다.

