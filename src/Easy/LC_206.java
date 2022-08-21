package Easy;

import DataStructure.ListNode;

public class LC_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = head.next, next = mid.next;
        head.next = null;
        while (mid != null) {
            mid.next = head;
            head = mid;
            mid = next;
            next = next == null ? null : next.next;
        }
        return head;
    }
}
