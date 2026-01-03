#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h> 

int isValidString(char* s) {
    int n = strlen(s);
    if (n == 0 || n > 100) return 0; 
    
    for (int i = 0; i < n; i++) {
        if (!islower(s[i])) { 
            printf("Error: '%c'는 소문자가 아닙니다.\n", s[i]);
            return 0;
        }
    }
    return 1;
}

int maxFreqSum(char* s) {
    int cntArray[26] = {0};
    int n = strlen(s);
    
    for(int i = 0; i < n; i++){
        cntArray[s[i] - 'a'] += 1;
    }
    
    int max_vowels = 0;
    int max_consonants = 0;

    int vowelMask = (1 << 0) | (1 << 4) | (1 << 8) | (1 << 14) | (1 << 20);

    for(int i = 0; i < 26; i++){
        if (vowelMask & (1 << i)) { 
            if(max_vowels < cntArray[i]) max_vowels = cntArray[i];
        }
        else {
            if(max_consonants < cntArray[i]) max_consonants = cntArray[i];
        }
    }
    return max_consonants + max_vowels;
}

int main(){
    char* s = (char*)malloc(101);
    
    if(s == NULL) {
        fprintf(stderr, "Memory Allocation Failed\n");
        return 1;
    }

    printf("단어 입력 (영어 소문자만, 최대 100자): ");
    
    if (scanf("%s", s) != 1) {
        printf("입력 오류 발생\n");
        free(s);
        return 1;
    }

    if (!isValidString(s)) {
        printf("유효하지 않은 입력입니다. 프로그램을 종료합니다.\n");
        free(s); 
        return 1;
    }

    int result = maxFreqSum(s);
    printf("Result: %d\n", result);

    free(s); 
    return 0;
}