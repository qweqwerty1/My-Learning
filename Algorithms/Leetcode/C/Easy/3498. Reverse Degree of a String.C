#include <stdio.h>
#include <string.h>

int reverseDegree(char* s) {
    int result = 0;
    int n = strlen(s);
    int cnt = 1;

    for(int i = 0;i < n;i++) {
        int alpha = 26 - (s[i] - 'a');
        result += alpha * cnt++;
    }

    return result;
}

int main() {
    char* s = "zaza";
    int result = reverseDegree(s);
    printf("result : %d",result);
    return 0;
}