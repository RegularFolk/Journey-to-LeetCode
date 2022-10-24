package Leet.Medium;

import DataStructure.ListNode;

public class LC_328 {
    public static void main(String[] args) {

    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode mark = head.next;
        ListNode cursor = dummy;
        ListNode temp;
        boolean odd = true;
        while (cursor.next != null) {
            if (cursor == dummy) {
                cursor = cursor.next;
            }
            temp = cursor.next;
            if (cursor.next.next != null) {
                cursor.next = cursor.next.next;
                cursor = temp;
                odd = !odd;
            } else {
                if (odd) {  //�������ڵ����
                    cursor.next = mark;
                } else {   //ż���ڵ����
                    cursor.next = null;
                    temp.next = mark;
                }
                break;
            }
        }
        return dummy.next;
    }
}
