#include<stdio.h>
#include<stdlib.h>

int* getSneakyNumbers(int* nums, int numsSize, int* returnSize) {
    int cnt[102] = {0};
    int* result = (int*)malloc(2 * sizeof(int));
    if (result == NULL) {return NULL;}
    *returnSize = 2;
    int count = 0;
    for (int i = 0;i < numsSize;i++) { cnt[nums[i]] += 1; }
    for (int i = 0;i < 102;i++) {
        if (cnt[i] == 2) {
            result[count] = i;
            count += 1;
            if (count == 2) break;
        }
    }
    return result;

}

int main() {
    int numsSize = 12;
    int nums[12] = {7,1,5,4,3,4,6,0,9,5,8,2};
    int returnSize = 0;
    int* result = getSneakyNumbers(nums, numsSize, &returnSize);    
    printf("getSneakyNumbers : %d %d",result[0],result[1]);

    free(result);
    return 0;
}