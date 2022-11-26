package LeetCode.Easy;

import DataStructure.ListNode;

public class LC_234 {

    public  boolean isPalindrome(ListNode head){
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }

        ListNode ahead = head;
        ListNode half = head;
        int step = 0;
        while (ahead != null) {
            if (step == 2) {
                half = half.next;
                step = 0;
            }
            ahead = ahead.next;
            step++;
        }

        ListNode newHead = null;
        while (half.next != null) {
            half = half.next;
            ListNode temp = new ListNode(half.val);
            temp.next = newHead;
            newHead = temp;
        }
        while (newHead != null) {
            if (newHead.val != head.val) {
                return false;
            } else {
                newHead = newHead.next;
                head = head.next;
            }
        }
        return true;
    }
}
