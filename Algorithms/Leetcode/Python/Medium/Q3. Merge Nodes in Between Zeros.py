class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeNodes(self, head):
        arr = []
        sum_nums = 0

        while head:
            if head.val == 0 and sum_nums > 0:
                arr.append(ListNode(sum_nums))
                sum_nums = 0
            else:
                sum_nums += head.val
            head = head.next
        
        result_Node = arr[0]
        cur = result_Node
        i = 1
        while i < len(arr):
            cur.next = arr[i]
            i += 1
            cur = cur.next

        return result_Node

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