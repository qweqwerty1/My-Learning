import math

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def insertGreatestCommonDivisors(self, head):
        cur = head

        while cur and cur.next:
           gcd_node = math.gcd(cur.val, cur.next.val)
           add_node = ListNode(gcd_node,cur.next)
           cur.next = add_node
           cur = cur.next.next

        return head

def main():
    Node_2 = ListNode(10)
    Node_1 = ListNode(2,Node_2)
    head = ListNode(3, Node_1)
    sol = Solution()
    print(sol.insertGreatestCommonDivisors(head))

if __name__ == "__main__":
    main()