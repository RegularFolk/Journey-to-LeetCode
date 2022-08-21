package CrackCodeInterview;

import DataStructure.ListNode;

public class Interview_02_08 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = new ListNode(0), slow = new ListNode(0);
        fast.next = slow.next = head;
        ListNode mark = slow;
        while (fast != null && fast.next != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        int len = 1;
        while (fast.next != slow) {
            fast = fast.next;
            len++;
        }
        slow = mark.next;
        fast = mark;
        while (len-- > 0) {
            fast = fast.next;
        }
        while (fast.next != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
