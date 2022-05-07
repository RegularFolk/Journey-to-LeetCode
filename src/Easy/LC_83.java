package Easy;

import java.util.List;

public class LC_83 {
    public static void main(String[] args) {

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

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101, head);
        ListNode cursor = dummy;
        ListNode mark = dummy;
        while (cursor.next != null) {
            if (cursor.next.val == mark.val) {
                cursor.next = cursor.next.next;
            } else {
                mark = cursor.next;
                cursor = mark;
            }
        }
        return dummy.next;
    }
}
