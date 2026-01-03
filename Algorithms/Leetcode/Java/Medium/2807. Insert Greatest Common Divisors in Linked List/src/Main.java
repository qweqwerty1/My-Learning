public class Main {
    public static void main(String[] args){
        ListNode N4 = new ListNode(3);
        ListNode N3 = new ListNode(10,N4);
        ListNode N2 = new ListNode(6,N3);
        ListNode head = new ListNode(18,N2);

        Solution sol = new Solution();
        head = sol.insertGreatestCommonDivisors(head);
        head.PrintNode();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    void PrintNode (ListNode this) {
        ListNode ptr = this;
        while(ptr != null) {
            System.out.printf("%d ",ptr.val);
            ptr = ptr.next;
        }
        System.out.println();
    }
}

class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode ptr = head;
        while (ptr.next != null) {
            ptr.next = new ListNode(GCD(ptr.val, ptr.next.val),ptr.next);
            ptr = ptr.next.next;
        }
        return head;
    }

    int GCD (int a, int b) {
        while (b > 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}