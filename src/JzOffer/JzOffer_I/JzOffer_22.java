package JzOffer.JzOffer_I;

import DataStructure.ListNode;

public class JzOffer_22 {
    public ListNode getKthFromEnd(ListNode head, int k) { //快慢指针
        ListNode l = new ListNode(0), r = new ListNode(0);
        l.next = r.next = head;
        while (k > 0 && r.next != null) {
            k--;
            r = r.next;
        }
        if (k != 0) {
            throw new RuntimeException("链表过短！");
        }
        while (r.next != null) {
            r = r.next;
            l = l.next;
        }
        return l.next;
    }
}
