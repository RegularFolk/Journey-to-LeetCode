package JzOffer.JzOffer_II;

import DataStructure.ListNode;

public class JzOfferII_021 {
    /*
     * ɾ����K���ڵ㣬����ָ��
     * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(), left = dummy, right = dummy;
        dummy.next = head;
        while (n-- > 0) right = right.next;
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
