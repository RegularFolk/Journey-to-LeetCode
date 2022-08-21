package CrackCodeInterview;

import DataStructure.ListNode;

public class Interview_02_02 {
    public int kthToLast(ListNode head, int k) {
        if (head == null) {
            throw new RuntimeException();
        }
        ListNode right = head, left = head;
        while (k-- > 0) {
            right = right.next;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        return left.val;
    }
}
