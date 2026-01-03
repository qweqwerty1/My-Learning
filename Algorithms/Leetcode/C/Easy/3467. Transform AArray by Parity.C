#include<stdio.h>
#include<stdlib.h>

int* transformArray(int*, int, int*);

int main(){
    int numsSize;
    printf("배열의 크기를 입력하세요 : ");
    scanf("%d",&numsSize);
    int returnSize = 0;
    int* nums = (int*)malloc(numsSize * sizeof(int));
    if (nums == NULL) return 1;
    for(int i = 0;i < numsSize;i++){
        printf("%d번째 원소의 값 : ",i);
        int v = 0;
        scanf("%d",&v);
        nums[i] = v;
    }
    int* result = transformArray(nums,numsSize,&returnSize);
    printf("결과 값 : ");
    for(int i = 0;i < returnSize;i++) {
        printf("%d ",result[i]);
    }
    free(result);
    free(nums);
    return 0;
}

int* transformArray(int* nums, int numsSize, int* returnSize) {
    int* result = (int*)calloc(numsSize, sizeof(int));
    if (result == NULL) return NULL;
    int oddNums = 0;
    int evenNums = 0;
    for(int i = 0;i < numsSize;i++){
        if(nums[i]%2 == 0) {
            evenNums++;
        }
        else oddNums++;
    }
    for(int i = evenNums;i < numsSize;i++){
        result[i] = 1;
    }
    *returnSize = numsSize;
    return result;
}