#include <stdio.h>
#include <stdlib.h>

int dfs(int* nums, int numSize, int index, int XOR) {
    if (index == numSize) {
        return XOR;
    }

    int include = dfs(nums, numSize, index + 1, XOR ^ nums[index]);
    int exclude = dfs(nums, numSize, index + 1, XOR);

    return include + exclude;
}

int subsetXORSum(int* nums, int numsSize) {
    return dfs(nums, numsSize, 0, 0);
}

int main() {
    int nums[6] = {3,4,5,6,7,8};
    int numSize = 6;
    int result = subsetXORSum(nums, numSize);
    printf("subsetXORSum : %d",result);
    return 0;
}

