#include<stdio.h>
#include<string.h>
#include<stdlib.h>

/* Pre-declaration */
int numJewelsInStones(char*, char*);
int ischarinString(char*, char);

/* Main */
int main(){
    char* stones = "aAAbbbb";
    int jewelSize = 0;
    printf("보석(주얼)의 크기를 입력하세요 : ");
    scanf("%d",&jewelSize);
    char* jewels = (char*)malloc(jewelSize + 1 * sizeof(char));
    if (jewels == NULL) return 1;
    printf("개수에 맞는 문자 입력 : ");
    scanf("%s",jewels);
    int result = numJewelsInStones(jewels, stones);
    printf("결과 값 : %d",result);

    free(jewels);
    return 0;
}

/* Function */
int numJewelsInStones(char* jewels, char* stones) {
    int result = 0;
    int n = strlen(jewels);
    for(int i = 0;i < n;i++){
        result += ischarinString(stones, jewels[i]);
    }
    return result;
}

int ischarinString(char* str, char c) {
    int n = strlen(str);
    int cnt = 0;
    for (int i = 0;i < n;i++){
        if (str[i] == c) cnt++;
    }
    return cnt;
}