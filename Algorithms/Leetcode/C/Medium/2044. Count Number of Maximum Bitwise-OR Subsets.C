#include<stdio.h>
#include<stdlib.h>

int countMaxOrSubsets(int*, int);
int DFS(int*, int,int,int,int);

int main(){
    int numsSize;
    printf("배열의 크기를 정하세요 : ");
    scanf("%d",&numsSize);
    int* nums = (int*)malloc(numsSize * sizeof(int));
    if (nums == NULL) return 1;
    for(int i = 0;i < numsSize;i++){
        printf("%d번째 값 입력 : ",i + 1);
        scanf("%d",&nums[i]);
    }
    int result = countMaxOrSubsets(nums,numsSize);
    printf("결과 값 : %d",result);

    free(nums);
    return 0;
}

int DFS(int* nums, int numsSize, int k, int idx, int currentNum) {
    if (idx == numsSize) return (currentNum == k) ? 1:0; 

    int left_value = DFS(nums, numsSize, k, idx + 1, nums[idx]|currentNum);
    int right_value = DFS(nums, numsSize, k, idx + 1, currentNum);

    return left_value + right_value;
}

int countMaxOrSubsets(int* nums, int numsSize) {
    int k = 0;
    for(int i = 0;i < numsSize;i++){
        k = k|nums[i];
    }
    int idx = 0;
    int currentNum = 0;
    return DFS(nums,numsSize,k,idx,currentNum);
}