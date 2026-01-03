#include <stdio.h>
#include <stdlib.h>

int numIdenticalPairs(int* nums, int numsSize) {
    int result = 0;
    int hashTable[101] = {0};
    for (int i = 0;i < numsSize;i++) {
        hashTable[nums[i]] += 1;
    }
    for (int i = 0;i < numsSize;i++) {
        hashTable[nums[i]] -= 1;
        if (hashTable[nums[i]] > 0) {
            result += hashTable[nums[i]];
        }
    }
    return result;
}

int main() {
    int numsSize = 4;
    int nums[4] = {1,1,1,1};
    int result = numIdenticalPairs(nums, numsSize);
    printf("Number of Good Pairs : %d\n",result);
    return 0;
}