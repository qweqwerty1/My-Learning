#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int finalValueAfterOperations(char** operations, int operationsSize) {
    int cnt = 0;
    for (int i = 0;i < operationsSize;i++) {
        if ((*operations)[1] == '+') {
            cnt += 1;
        }
        else { cnt -= 1; }
        operations += 1;
    }
    return cnt;
}

int main() {
    int operationsSize = 3;
    char* operation[3] = {"++X","X++","--X"};
    char** operations = operation;
    int result = finalValueAfterOperations(operations, operationsSize);
    printf("%d", result);
    return 0;
}