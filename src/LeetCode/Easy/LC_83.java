package LeetCode.Easy;

import DataStructure.ListNode;

public class LC_83 {
    public static void main(String[] args) {

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101, head);
        ListNode cursor = dummy;
        ListNode mark = dummy;
        while (cursor.next != null) {
            if (cursor.next.val == mark.val) {
                cursor.next = cursor.next.next;
            } else {
                mark = cursor.next;
                cursor = mark;
            }
        }
        return dummy.next;
    }
}
