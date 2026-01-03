#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int* recoverOrder(int* order, int orderSize, int* friends, int friendsSize, int* returnSize) {
    int* result = (int*)calloc(friendsSize, sizeof(int));
    if (result == NULL) { return NULL; }
    int* ptr = result;

    for(int i = 0;i < orderSize; i++) {
        for(int j = 0;j < friendsSize; j++) {
            if (order[i] == friends[j]) { 
                *ptr = order[i];
                ptr += 1;
            }
        }
    }

    size_t rSize = 0;

    for(int i = 0;i < friendsSize;i++) {
        if (result[i] == 0) { break; }
        rSize += 1;
    }

    *returnSize = rSize;

    int* new_ptr = (int*)realloc(result, rSize * sizeof(int));

    if (new_ptr == NULL) { return NULL; }
    else { result = new_ptr; }

    return result;
}

int main() {
    int* order = (int*)malloc(5 * sizeof(int));
    memcpy(order, (int[]){3,1,2,5,4}, 5 * sizeof(int));
    int orderSize = 5;
    int* friends = (int*)malloc(3 * sizeof(int));
    memcpy(friends, (int[]){1,3,4}, 3 * sizeof(int));
    int friendsSize = 3;
    int returnSize = 0;
    
    int* result = recoverOrder(order, orderSize, friends, friendsSize, &returnSize);
    int * ptr = result;
    for (int i = 0;i < returnSize;i++) {
        printf("%d ", *ptr);
        ptr += 1;
    }

    printf("\n");
    free(result);
    free(order);
    free(friends);

    return 0;
}