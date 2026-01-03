#include<stdio.h>
#include<stdlib.h>

int alternatingSum(int*, int);

int main(){
    int numsSize;
    printf("배열의 크기를 정하세요 : ");
    scanf("%d",&numsSize);
    int* nums = (int*)malloc(numsSize * sizeof(int));
    if (nums == NULL) return 1;
    for(int i = 0;i < numsSize;i++) {
        int n;
        printf("%d번째 원소의 값 : ",i);
        scanf("%d",&n);
        nums[i] = n;
    }
    int result = alternatingSum(nums, numsSize);
    printf("결과 값 : %d",result);

    free(nums);
    return 0;
}

int alternatingSum(int* nums, int numsSize) {
    int result = 0;
    for(int i = 0;i < numsSize;i++){
        if(i%2 == 0) result += nums[i];
        else result -= nums[i];
    }
    return result;
}