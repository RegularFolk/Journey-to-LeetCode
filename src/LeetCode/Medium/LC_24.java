package LeetCode.Medium;

import DataStructure.ListNode;

public class LC_24 {

    /*
     * 链表翻转的变换
     * */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0), cur1 = head, cur2 = head.next, prev = dummy;
        while (cur1 != null && cur2 != null) {
            prev.next = cur2;
            cur1.next = cur2.next;
            cur2.next = cur1;
            prev = cur1;
            cur1 = cur1.next;
            if (cur1 != null) {
                cur2 = cur1.next;
            }
        }
        return dummy.next;
    }
}
