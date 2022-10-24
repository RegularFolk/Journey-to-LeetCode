package Leet.Medium;

import DataStructure.ListNode;

public class LC_1721 {
    /*
     * �������������k���ڵ�͵�����k���ڵ�
     * */
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0), fast = dummy, slow = head;
        ListNode mark;
        dummy.next = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        mark = fast;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        int val = mark.val;
        mark.val = slow.val;
        slow.val = val;
        return dummy.next;
    }
}
