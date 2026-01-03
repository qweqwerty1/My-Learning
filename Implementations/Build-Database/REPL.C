#if defined(_MSC_VER)
#include <BaseTsd.h>
typedef SSIZE_T ssize_t;
#endif
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<string.h>

ssize_t getline(char **lineptr, size_t *n, FILE *stream) {
    size_t pos = 0;
    int c;

    if (*lineptr == NULL) {
        *lineptr = (char*)malloc(128);
        *n = 128;
    }

    while((c = getc(stream)) != EOF) {
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
    }

    if (c == EOF && pos == 0) return -1;
    ((char *)*lineptr)[pos] = '\0';
    return pos;
}

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

void print_prompt() { printf("db > "); }

void read_input(InputBuffer* input_buffer) {
    ssize_t bytes_read = getline(&(input_buffer->buffer), &(input_buffer->buffer_length), stdin);

    if (bytes_read <= 0) {
        printf("Error reading input\n");
        exit(EXIT_FAILURE);
    }

    // 후행 줄 바꿈 제거
    input_buffer->input_length = bytes_read - 1;
    input_buffer->buffer[bytes_read - 1] = '\0';
}

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