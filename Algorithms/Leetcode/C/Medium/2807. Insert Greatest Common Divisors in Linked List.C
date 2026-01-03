#include <stdio.h>
#include <stdlib.h>

int calculate_gcd(int a, int b) {
    while (b != 0) {
        int temp = a % b;
        a = b;
        b = temp;
    }
    return a;
}

struct ListNode {
    int val;
    struct ListNode *next;
};

struct ListNode* insertGreatestCommonDivisors(struct ListNode* head) {
    if (head == NULL || head->next == NULL) return head;
    struct ListNode* ptr = head;
    while(ptr != NULL && ptr->next != NULL) {
        int a = ptr->val;
        int b = ptr->next->val;
        int gcd_ab = calculate_gcd(a,b);
        struct ListNode* newNode = (struct ListNode*)malloc(sizeof(struct ListNode));
        newNode->val = gcd_ab;
        newNode->next = ptr->next;
        ptr->next = newNode;
        ptr = ptr->next->next;
    }
    return head;
}

struct ListNode* createNode(int val) {
    struct ListNode* newNode = (struct ListNode*)malloc(sizeof(struct ListNode));
    newNode->val = val;
    newNode->next = NULL;
    return newNode;
}

void printList(struct ListNode* head) {
    struct ListNode* ptr = head;
    while (ptr != NULL) {
        printf("%d", ptr->val);
        if (ptr->next != NULL) printf(" -> ");
        ptr = ptr->next;
    }
    printf("\n");
}

void freeList(struct ListNode* head) {
    struct ListNode* tmp;
    while (head != NULL) {
        tmp = head;
        head = head->next;
        free(tmp);
    }
}

int main() {
    struct ListNode* head = createNode(18);
    head->next = createNode(6);
    head->next->next = createNode(10);
    head->next->next->next = createNode(3);

    printf("변경 전: ");
    printList(head);

    head = insertGreatestCommonDivisors(head);

    printf("변경 후: ");
    printList(head);

    freeList(head);
    return 0;
}