package Medium;

import DataStructure.ListNode;

public class LC_142 {
    /*
     * »·ÐÎÁ´±í
     * */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0), slow = dummy, fast = dummy;
        dummy.next = head;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast && fast != null && fast.next != null);
        if (fast == null || fast.next == null) {
            return null;
        }
        int len = 1;
        fast = fast.next;
        while (fast != slow) {
            fast = fast.next;
            len++;
        }
        fast = dummy;
        slow = dummy;
        while (len-- > 0) {
            fast = fast.next;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
