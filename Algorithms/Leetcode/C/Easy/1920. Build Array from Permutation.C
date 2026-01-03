#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int* buildArray(int* nums, int numsSize, int* returnSize) {
    int* result = (int*)malloc(numsSize * sizeof(int));

    if (result == NULL) { 
        *returnSize = 0;
        return NULL;
    }

    for (int i = 0;i < numsSize;i++) {
        result[i] = nums[nums[i]];
    }
    *returnSize = numsSize;
    
    return result;
}

int main() {
    int numsSize = 6;
    int* nums = (int*)malloc(numsSize * sizeof(int));
    memcpy(nums,(int[]){0,2,1,5,3,4}, numsSize * sizeof(int));
    int returnSize = 0;
    int* result = buildArray(nums, numsSize, &returnSize);

    printf("buildArray result : ");
    for (int i = 0;i < returnSize; i++) {
        printf("%d ",result[i]);
    }
    printf("\n");

    free(nums);
    free(result);

    return 0;
}