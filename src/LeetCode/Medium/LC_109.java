package LeetCode.Medium;

import DataStructure.ListNode;
import DataStructure.TreeNode;

public class LC_109 {
    /*
     * LC_971的链表版
     * 用标记值区分两端链表，而不是真的断开
     * */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null || head.val == Integer.MAX_VALUE) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode mid = getMid(head);
        TreeNode treeNode = new TreeNode(mid.val);
        mid.val = Integer.MAX_VALUE;
        treeNode.left = sortedListToBST(head);
        treeNode.right = sortedListToBST(mid.next);
        return treeNode;
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = new ListNode(0), fast = new ListNode(0);
        slow.next = head;
        fast.next = head;
        while (fast != null && fast.next != null &&
                fast.val != Integer.MAX_VALUE && fast.next.val != Integer.MAX_VALUE) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
