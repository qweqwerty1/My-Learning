class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def getDecimalValue(self, head):
        cur = head
        num = 0

        while cur:
            num = (num << 1) | cur.val
            cur = cur.next

        return num

def main():
    node2 = ListNode(1, None)
    node1 = ListNode(0, node2)
    head = ListNode(1, node1)
    sol = Solution()
    print(sol.getDecimalValue(head))

if __name__ == "__main__":
    main()