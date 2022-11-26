package JzOffer.JzOffer_II;

import DataStructure.ListNode;

public class JzOfferII_022 {
    /*
     * 1.判断是否有环
     * 2.判断环的长度
     * 3.找出入口
     * */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(), slow = dummy, fast = dummy;
        dummy.next = head;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != null && fast.next != null && fast != slow);
        if (fast == null || fast.next == null) return null;
        int len = 0;
        do {
            fast = fast.next;
            len++;
        } while (fast != slow);
        fast = dummy;
        slow = dummy;
        while (len-- > 0) fast = fast.next;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
