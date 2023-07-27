package LeetCode.Medium;

import DataStructure.ListNode;

public class LC_19 {
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode quickCursor = dummy;
        ListNode slowCursor = dummy;
        int step = 0;
        while (step < n && quickCursor.next != null) {
            quickCursor = quickCursor.next;
            step++;
        }
        while (quickCursor.next != null) {
            slowCursor = slowCursor.next;
            quickCursor = quickCursor.next;
        }
        slowCursor.next = slowCursor.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode cursor = dummy;
        int total = 0;
        while (head != null) {
            head = head.next;
            total++;
        }
        for (int i = 1; i < total - n + 1; i++) {
            cursor = cursor.next;
        }
        cursor.next = cursor.next.next;
        return dummy.next;
    }
}

class redo_19 {
    /*
     * 双指针，让一个指针走快点
     * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(), cursor = dummy, lead = cursor;
        dummy.next = head;
        while (n-- > 0) {
            lead = lead.next;
        }
        while (lead.next != null) {
            lead = lead.next;
            cursor = cursor.next;
        }
        cursor.next = cursor.next.next;
        return dummy.next;
    }
}
