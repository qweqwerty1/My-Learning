#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int* getConcatenation(int* nums, int numsSize, int* returnSize) {
    int* result = (int*)malloc(numsSize * 2 * sizeof(int));
    if (result == NULL) { 
        *returnSize = 0;
        return NULL;
    }
    *returnSize = numsSize * 2;
    for (int i = 0;i < numsSize;i++) {
        result[i] = nums[i];
        result[i+numsSize] = nums[i];
    }
    return result;
}

int main() {
    int numsSize = 3;
    int* nums = (int*)malloc(numsSize * sizeof(int));
    if (nums == NULL) {
        fprintf(stderr,"Memory Allocation Failed\n");
        return 1;
    }
    memcpy(nums,(int[]){1,2,1},numsSize * sizeof(int));
    int returnSize = 0;
    int* result = getConcatenation(nums,numsSize,&returnSize);

    printf("getConcatenation : ");
    for(int i = 0;i < returnSize;i++){
        printf("%d ",result[i]);
    }

    free(nums);
    free(result);

    return 0;
}