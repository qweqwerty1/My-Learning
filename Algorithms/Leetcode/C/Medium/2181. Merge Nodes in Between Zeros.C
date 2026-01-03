#include <stdio.h>
#include <stdlib.h>

struct ListNode {
    int val;
    struct ListNode *next;
};

struct ListNode* mergeNodes(struct ListNode* head) {
    struct ListNode* dummy = (struct ListNode*)malloc(sizeof(struct ListNode));
    if (dummy == NULL) { return NULL; }
    dummy->val = 0;
    dummy->next = NULL;
    struct ListNode* ptr = head->next;
    struct ListNode* tail = dummy;

    int sum = 0;

    while (ptr != NULL) {
        if(ptr->val == 0) {
            struct ListNode* AddNode = (struct ListNode*)malloc(sizeof(struct ListNode));
            if (AddNode == NULL) { return NULL; }
            AddNode->val = sum;
            AddNode->next = NULL;
            tail->next = AddNode;
            tail = tail->next;
            sum = 0;
        }
        else sum += ptr->val;

        ptr = ptr->next;
    }

    struct ListNode* result = dummy->next;

    free(dummy);

    return result;
}

struct ListNode* AddNodes() {
    int n = 0;
    printf("추가할 노드 개수를 입력하세요 : ");
    scanf("%d", &n);
    printf("\n");
    struct ListNode* dummy = (struct ListNode*)malloc(sizeof(struct ListNode));
    if(dummy == NULL) {return NULL; };
    dummy->val = 0;
    dummy->next = NULL;
    struct ListNode* tail = dummy;

    for (int i = 0;i < n;i++) {
        int value;
        printf("%d번째 숫자 입력 : ",i+1);
        scanf("%d",&value);
        struct ListNode* newNode = (struct ListNode*)malloc(sizeof(struct ListNode));
        if (newNode == NULL) { return NULL; }
        newNode->val = value;
        newNode->next = NULL;
        tail->next = newNode;
        tail = tail->next;
    }

    struct ListNode* result = dummy->next;
    free(dummy);
    return result;
}

void FreeNodes(struct ListNode* node) {
    struct ListNode* ptr = node;
    while (ptr != NULL) {
        ptr = ptr->next;
        free(node);
        node = ptr;
    }
    return;
}

void PrintNodes(struct ListNode* ptr) {
    printf("문제의 정답 노드의 값은 : ");
    while (ptr != NULL) {
        printf("%d ",ptr->val);
        ptr = ptr->next;
    }
    printf("\n");
}

int main() {
    struct ListNode* head = AddNodes();
    struct ListNode* result = mergeNodes(head);
    PrintNodes(result);
    FreeNodes(head);
    FreeNodes(result);
    head = NULL;
    result = NULL;
    return 0;
}