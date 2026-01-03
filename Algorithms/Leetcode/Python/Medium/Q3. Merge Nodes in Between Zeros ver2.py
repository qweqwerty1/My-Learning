class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeNodes(self, head):
        modify_ptr = head
        scan_ptr = head.next
        current_sum = 0

        while scan_ptr:
            if scan_ptr.val == 0:
                modify_ptr.next = ListNode(current_sum)
                modify_ptr = modify_ptr.next
                current_sum = 0
            else:
                current_sum += scan_ptr.val
            scan_ptr = scan_ptr.next
            
        modify_ptr.next = None

        return head.next

def main():
    p_last_node = ListNode(0)
    p_node3 = ListNode(2,p_last_node)
    p_node2 = ListNode(5,p_node3)
    p_node1 = ListNode(4,p_node2)
    last_node = ListNode(0,p_node1)
    node_2 = ListNode(1,last_node)
    node_1 = ListNode(3,node_2)
    head = ListNode(0,node_1)
    sol = Solution()
    print(sol.mergeNodes(head))
    
if __name__ == "__main__":
    main()