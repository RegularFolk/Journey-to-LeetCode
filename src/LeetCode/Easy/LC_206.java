package LeetCode.Easy;

import DataStructure.ListNode;

public class LC_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = head.next, next = mid.next;
        head.next = null;
        while (mid != null) {
            mid.next = head;
            head = mid;
            mid = next;
            next = next == null ? null : next.next;
        }
        return head;
    }
}

class redo_206 {
    /*
     * 经典的反转链表操作
     * 设计三个指针，prev、cur、next
     * */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head, prev = null, next = cur.next;
        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;
        return cur;
    }
}
