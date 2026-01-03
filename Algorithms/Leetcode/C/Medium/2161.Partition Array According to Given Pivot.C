#include <stdio.h>
#include <stdlib.h>

int* pivotArray(int* nums, int numsSize, int pivot, int* returnSize) {
    int* result = (int*)malloc(numsSize * sizeof(int));
    int* lowNums = (int*)malloc(numsSize * sizeof(int));
    int* highNums = (int*)malloc(numsSize * sizeof(int));
    if (result == NULL || lowNums == NULL || highNums == NULL) return NULL;

    int Ecnt = 0;
    int Lcnt = 0;
    int Hcnt = 0;
    for (int i = 0;i < numsSize;i++) {
        if(nums[i] > pivot) {
            highNums[Hcnt++] = nums[i];
        } else if(nums[i] < pivot) {
            lowNums[Lcnt++] = nums[i];
        } else {
            Ecnt++;
        }
    }

    int idx = 0;
    for(int i = 0;i < Lcnt;i++) {
        result[idx++] = lowNums[i];
    }
    for(int i = 0;i < Ecnt;i++) {
        result[idx++] = pivot;
    }
    for(int i = 0;i < Hcnt;i++) {
        result[idx++] = highNums[i];
    }

    free(lowNums);
    free(highNums);

    *returnSize = numsSize;

    return result;
}


int main() {
    int numsSize = 7;
    int nums[numsSize] = {9,12,5,10,14,3,10};
    int pivot = 10;
    int returnSize = 0;

    int* result = pivotArray(nums,numsSize,pivot,&returnSize);
    printf("pivotArray : ");
    for (int i = 0;i < numsSize;i++) {
        printf("%d ",nums[i]);
    }
    return 0;
}