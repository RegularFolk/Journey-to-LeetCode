package JzOffer.JzOffer_II;

import DataStructure.ListNode;

public class JzOfferII_023 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode dummy1 = new ListNode(), dummy2 = new ListNode(), cur1 = dummy1, cur2 = dummy2;
        dummy1.next = headA;
        dummy2.next = headB;
        while (cur1.next != null) {
            cur1 = cur1.next;
            lenA++;
        }
        while (cur2.next != null) {
            cur2 = cur2.next;
            lenB++;
        }
        return lenA >= lenB ? getShare(dummy1, dummy2, lenA - lenB) : getShare(dummy2, dummy1, lenB - lenA);
    }

    private ListNode getShare(ListNode head1, ListNode head2, int diff) {
        while (diff-- > 0) head1 = head1.next;
        while (head1 != null && head2 != null && head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1 == head2 ? head1 : null;
    }
}
