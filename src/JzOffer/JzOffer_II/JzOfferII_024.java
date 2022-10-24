package JzOffer.JzOffer_II;

import DataStructure.ListNode;

public class JzOfferII_024 {
    /*
     * ��ת����ļ�д��
     * */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head, next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
