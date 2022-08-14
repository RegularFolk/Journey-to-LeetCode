package JzOffer;

import DataStructure.ListNode;

public class JzOffer_24 {
    public ListNode reverseList(ListNode head) {
        if (head != null) {
            if (head.next == null) {
                return head;
            } else if (head.next.next == null) {
                head.next.next = new ListNode(head.val);
                return head.next;
            } else {
                ListNode l = new ListNode(head.val), m = head.next, r = head.next.next;
                while (r != null) {
                    m.next = l;
                    l = m;
                    m = r;
                    r = r.next;
                }
                m.next = l;
                return m;
            }
        }
        return null;
    }
}
