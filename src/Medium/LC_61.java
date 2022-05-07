package Medium;

public class LC_61 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0, new ListNode(1, new ListNode(2)));
        System.out.println(rotateRight(head, 4));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode quickCursor = dummy;
        ListNode slowCursor = dummy;
        ListNode temp = dummy;
        int len = 0;
        int K;
        while (temp.next != null) {
            temp = temp.next;
            len++;
        }
        K = k % len;
        if (len == 1 || K == 0) {
            return head;
        }
        for (int i = 0; i < K; i++) {
            quickCursor = quickCursor.next;
        }
        while (quickCursor.next != null) {
            quickCursor = quickCursor.next;
            slowCursor = slowCursor.next;
        }
        temp = dummy.next;
        dummy.next = slowCursor.next;
        slowCursor.next = null;
        quickCursor.next = temp;
        return dummy.next;
    }
}
