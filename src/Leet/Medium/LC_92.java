package Leet.Medium;

import DataStructure.ListNode;

public class LC_92 {
    public static void main(String[] args) {

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode slowCursor = dummy;
        ListNode quickCursor;
        ListNode newHead = null;
        ListNode tail = newHead;
        for (int i = 0; i < left - 1; i++) {
            slowCursor = slowCursor.next;
        }
        quickCursor = slowCursor.next;
        for (int i = 0; i <= right - left; i++) {
            if (newHead == null) {
                newHead = new ListNode(quickCursor.val);
                tail = newHead;
            } else {
                newHead = new ListNode(quickCursor.val, newHead);
            }
            quickCursor = quickCursor.next;
        }
        tail.next = quickCursor;
        slowCursor.next = newHead;
        return dummy.next;
    }
}
