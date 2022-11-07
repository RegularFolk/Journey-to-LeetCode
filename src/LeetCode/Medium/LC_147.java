package LeetCode.Medium;

import DataStructure.ListNode;

public class LC_147 {
    public static void main(String[] args) {

    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cursor1 = head;
        ListNode cursor2;
        ListNode temp;
        boolean flag;
        while (cursor1.next != null) {
            cursor2 = dummy;
            flag = true;
            while (cursor2 != cursor1) {
                if (cursor1.next.val < cursor2.next.val) {
                    temp = cursor1.next;
                    cursor1.next = cursor1.next.next;
                    temp.next = cursor2.next;
                    cursor2.next = temp;
                    flag = false;
                    break;
                }
                cursor2 = cursor2.next;
            }
            if (flag) {
                cursor1 = cursor1.next;
            }
        }
        return dummy.next;
    }
}
