#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int* findWordsContaining(char** words, int wordsSize, char x, int* returnSize) {
    int* result = (int*)malloc(51*sizeof(int));
    int cnt = 0;
    for (int i = 0;i < wordsSize;i++){
        int wordSize = strlen(words[i]);
        for (int j = 0;j < wordSize;j++){
            if (words[i][j] == x) { 
                result[cnt] = i;
                cnt += 1;
                break;
            }
        }
    }
    *returnSize = cnt;
    result[cnt] = -1;
    return result;
}

int main() {
    char* word[2] = {"leet","code"};
    char** words = word;
    char x = 'e';
    int wordsSize = 2;
    int returnSize = 0;
    int* result = findWordsContaining(words, wordsSize, x, &returnSize);
    printf("FindWordsContaining : ");
    for (int i = 0;result[i] != -1;i++) {
        printf("%d ", result[i]);
    }
    printf("\n");
    free(result);
    return 0;
}