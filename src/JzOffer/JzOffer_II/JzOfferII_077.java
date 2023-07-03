package JzOffer.JzOffer_II;

import DataStructure.ListNode;

public class JzOfferII_077 {
    /*
     * 链表的排序,利用归并排序
     * 常数级空间复杂度需要在原有链表的基础上操作
     * */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode left = head, right = getRight(head);
        left = sortList(left);
        right = sortList(right);
        ListNode dummy = new ListNode(), cur = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null ? right : left;
        return dummy.next;
    }

    //返回中间节点并且断开左右两半链表
    private ListNode getRight(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(), slow = dummy, fast = dummy;
        dummy.next = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        return fast;
    }

}
