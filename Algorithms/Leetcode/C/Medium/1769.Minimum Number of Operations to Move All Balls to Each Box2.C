#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int* minOperations(char* boxes, int* returnSize) {
    int boxSize = strlen(boxes);
    int* result = (int*)malloc(boxSize * sizeof(int));
    if (result == NULL) { return NULL; }
    
    int count = 0;
    int ops = 0;

    for (int i = 0;i < boxSize;i++) {
        result[i] = ops;

        if (boxes[i] == '1') { count += 1; }

        ops += count;
    }

    count = 0;
    ops = 0;

    for (int j = boxSize - 1;j >= 0;j--) {
        result[j] += ops;

        if (boxes[j] == '1') { count += 1; }

        ops += count;
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