#include <stdio.h>
#include <math.h>

int scoreOfString(char* s) {
    char* ptr1 = s;
    char* ptr2 = s;
    ptr1 += 1;
    int result = 0;

    while (*ptr1 != '\0') {
        result += abs(*ptr1 - *ptr2);
        ptr1 += 1;
        ptr2 += 1;
    }

    return result;
}

int main() {
    char* s = "hello";
    int result = scoreOfString(s);
    printf("Score of as String : %d", result);

    return 0;
}