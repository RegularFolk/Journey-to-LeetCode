package LeetCode.Easy;

import DataStructure.ListNode;

public class LC_21 {
    public static void main(String[] args) {
        mergeTwoLists(new ListNode(1, new ListNode(3, new ListNode(4))), new ListNode(1, new ListNode(2, new ListNode(4))));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0, null);
        ListNode cursor1 = l1;
        ListNode cursor2 = l2;
        ListNode cursor3 = newHead;
        while (cursor1 != null && cursor2 != null) {
            if (cursor2.val < cursor1.val) {
                cursor3.next = cursor2;
                cursor2 = cursor2.next;
            } else {
                cursor3.next = new ListNode(cursor1.val);
                cursor1 = cursor1.next;
            }
            cursor3 = cursor3.next;
        }
        if (cursor1 != null) {
            cursor3.next = cursor1.next;
        } else if (cursor2 != null) {
            cursor3.next = cursor2.next;
        }
        return newHead.next;
    }
}
