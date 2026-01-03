import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    ListNode head = NodeUtils.addNodes();

    Solution sol = new Solution();
    ListNode result = sol.mergeNodes(head);

    NodeUtils.printNodes(result);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class NodeUtils {
    private static final Scanner sc = new Scanner(System.in);
    static void printNodes(ListNode ptr) {
        System.out.print("변환 결과 노드 값 : ");
        while (ptr != null) {
            System.out.printf("%d ",ptr.val);
            ptr = ptr.next;
        }
    }

    static ListNode addNodes() {
        System.out.print("추가할 노드의 개수 : ");
        int n = sc.nextInt();
        ListNode head = new ListNode();
        ListNode ptr = head;

        for (int i = 0;i < n;i++) {
            System.out.printf("%d번째 노드의 값 : ",i + 1);
            int value = sc.nextInt();

            ptr.next = new ListNode(value);
            ptr = ptr.next;
        }
        return head.next;
    }
}

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode ptr = head.next;
        ListNode tail = dummy;
        int sum = 0;
        while (ptr != null) {
            if (ptr.val == 0) {
                tail.next = new ListNode(sum);
                tail = tail.next;
                sum = 0;
            }
            else { sum += ptr.val; }
            ptr = ptr.next;
        }

        return dummy.next;
    }
}