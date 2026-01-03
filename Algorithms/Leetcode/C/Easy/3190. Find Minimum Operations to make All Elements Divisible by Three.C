#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int minimumOperations(int* nums, int numsSize) {
    int cnt = 0;
    for (int i = 0;i < numsSize;i++) {
        if (nums[i] % 3 != 0) { cnt += 1; }
    }
    return cnt;
}

int main() {
    int numsSize = 4;
    int* nums = (int*)malloc(numsSize * sizeof(int));
    if (nums == NULL) { 
        fprintf(stderr, "Memory Allocation Failed\n");
        return 1; 
    }
    memcpy(nums, (int[]){1,2,3,4}, numsSize * sizeof(int));
    int result = minimumOperations(nums, numsSize);

    printf("minimumOperations : %d\n", result);

    free(nums);

    return 0;
}