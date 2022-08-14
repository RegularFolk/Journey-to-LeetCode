package JzOffer;

import DataStructure.ListNode;

public class JzOffer_18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode cursor = head;
        while (cursor.next != null) {
            if (cursor.next.val == val) {
                cursor.next = cursor.next.next;
                return head;
            }
            cursor = cursor.next;
        }
        throw new RuntimeException("不存在指定节点！");
    }
}
