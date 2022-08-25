package Medium;

import DataStructure.ListNode;

public class LC_86 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode
                (0, new ListNode(2, new ListNode(5, new ListNode(2)))))));
        System.out.println(partition(head, 3));
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0, head);
        ListNode quickCursor;
        ListNode slowCursor = dummy;
        ListNode temp;
        while (slowCursor.next != null) {
            if (slowCursor.next.val >= x) {
                break;
            }
            slowCursor = slowCursor.next;
        }
        quickCursor = slowCursor;
        while (quickCursor.next != null) {
            if (quickCursor.next.val < x) {
                temp = quickCursor.next;
                quickCursor.next = quickCursor.next.next;
                temp.next = slowCursor.next;
                slowCursor.next = temp;
                slowCursor = slowCursor.next;
            } else {
                quickCursor = quickCursor.next;
            }
            if (quickCursor == null) {
                break;
            }
        }
        return dummy.next;
    }
}
