package JzOfferII;

import DataStructure.ListNode;

public class JzOfferII_24 {
    /*
     * 反转链表的简单写法
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
