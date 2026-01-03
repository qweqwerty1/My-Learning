#include<stdio.h>
#include<stdlib.h>

int maximumWealth(int** accounts, int accountsSize, int* accountsColSize) {
    int result = 0;
    for(int i = 0; i < accountsSize; i++){
        int colSize = accountsColSize[i];
        int cnt = 0;
        for(int j = 0; j < colSize; j++){
            cnt += accounts[i][j];
        }
        if(cnt > result){
            result = cnt;
        }
    }
    return result;
}

int main(){
    int accountsSize;
    printf("전체 행의 개수(사람 수)를 입력하세요 : ");
    scanf("%d", &accountsSize);

    int** accounts = (int**)malloc(accountsSize * sizeof(int*));
    if(accounts == NULL) return 1;

    int* accountsColSize = (int*)malloc(accountsSize * sizeof(int));
    if(accountsColSize == NULL) return 1;

    for(int i = 0; i < accountsSize; i++){
        printf("%d번째 사람의 재산 개수 입력 : ", i);
        scanf("%d", &accountsColSize[i]); 

        int colSize = accountsColSize[i];

        int* newptr = (int*)malloc(colSize * sizeof(int));
        if(newptr == NULL) return 1;

        for(int j = 0; j < colSize; j++){
            int val;
            printf("accounts[%d][%d] 재산 금액 입력 : ", i, j);
            scanf("%d", &val);
            newptr[j] = val;
        }
        accounts[i] = newptr; 
    }

    int result = maximumWealth(accounts, accountsSize, accountsColSize);
    printf("가장 부유한 사람의 재산 : %d\n", result);

    for(int i = 0; i < accountsSize; i++){
        free(accounts[i]); 
    }
    free(accounts);        
    free(accountsColSize); 
    
    return 0;
}