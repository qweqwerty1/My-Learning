#include<stdio.h>
#include<stdlib.h>

int* shuffle(int* nums, int numsSize, int n, int* returnSize);

int main(){
    int numsSize;
    int returnSize = 0;
    printf("배열의 크기 : ");
    scanf("%d",&numsSize);
    int n = numsSize/2;
    int* nums = (int*)malloc(numsSize*sizeof(int));
    if (nums == NULL) return 1;

    for(int i = 0;i < numsSize;i++){
        printf("%d번째 원소의 값 : ",i);
        int v;
        scanf("%d",&v);
        nums[i] = v;
    }

    int* result = shuffle(nums,numsSize,n,&returnSize);
    printf("결과 값(배열) : ");
    for(int i = 0;i < returnSize;i++){
        printf("%d ",result[i]);
    }

    free(result);
    free(nums);
    return 0;
}

int* shuffle(int* nums, int numsSize, int n, int* returnSize){
    int* result = (int*)malloc(numsSize * sizeof(int));
    if (result == NULL) return NULL;

    int idx = 0;

    for (int i = 0;i < n;i++) {
        result[idx] = nums[i];
        ++idx;
        result[idx] = nums[i+n];
        ++idx;
    }

    *returnSize = numsSize;

    return result;
}