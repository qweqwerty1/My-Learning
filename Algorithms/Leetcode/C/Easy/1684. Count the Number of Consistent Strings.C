#include <stdio.h>
#include <string.h>

int countConsistentStrings(char * allowed, char ** words, int wordsSize){
    int hash[26] = {0};
    for(int i = 0;i < strlen(allowed);i++){
        hash[allowed[i] - 'a']++;
    } 
    
    int result = 0;

    for(int i = 0;i < wordsSize;i++) {
        char* word = words[i];
        int n = strlen(word);
        int flag = 0;
        for(int j = 0;j < n;j++){
            if(hash[word[j] - 'a'] == 0) {
                flag = 1;
                break;
            }
        }
        if(flag == 0) result++;
    }

    return result;
}

int main() {
    int wordsSize = 5;
    char* words[] = {"ad","bd","aaab","baa","badab"};
    char* allowed = "ab";
    int result = countConsistentStrings(allowed, words, wordsSize);
    printf("%d", result);

    return 0;
}