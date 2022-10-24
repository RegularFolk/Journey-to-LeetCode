package Leet.Easy;

import DataStructure.ListNode;

public class LC_203 {
    /*
     * 链表基本操作
     * */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0), cursor = dummy;
        dummy.next = head;
        while (cursor.next != null) {
            if (cursor.next.val == val) {
                cursor.next = cursor.next.next;
            }else cursor = cursor.next;
        }
        return dummy.next;
    }

}
