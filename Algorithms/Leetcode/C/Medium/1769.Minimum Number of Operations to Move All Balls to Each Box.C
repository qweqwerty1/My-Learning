#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int* minOperations(char* boxes, int* returnSize) {
    int boxSize = strlen(boxes);
    int* result = (int*)malloc(boxSize * sizeof(int));
    if (result == NULL) { return NULL; }
    for (int i = 0;i < boxSize;i++) {
        int cnt = 0;
        for(int j = 0;j < boxSize;j++){
            if (boxes[j] == '1'){
                cnt += abs(j - i);
            }
        }
        result[i] = cnt;
    }
    *returnSize = boxSize;
    return result;
}

int main() {
    char* boxes = "001011";
    int returnSize = 0;
    int* result = minOperations(boxes, &returnSize);
    printf("minOperations : ");
    for (int i = 0;i < returnSize;i++) {
        printf("%d ",result[i]);
    }

    free(result);
    return 0;
}