package LeetCode.Medium;

import DataStructure.ListNode;

public class LC_82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cursor = dummy;
        boolean flag = false;
        while (cursor.next != null && cursor.next.next != null) {
            if (flag && cursor.next.val != cursor.next.next.val) {
                cursor.next = cursor.next.next;
                flag = false;
            } else if (cursor.next.val == cursor.next.next.val) {
                cursor.next = cursor.next.next;
                if (!flag) {
                    flag = true;
                }
            } else {
                cursor = cursor.next;
            }
        }
        if (flag) {
            cursor.next = null;
        }
        return dummy.next;
    }
}

class redo_82 {
    /*
     * 移除存在相同的所有节点
     * 使用两个个指针，prev、cur
     * 注意点在于当进行了删除操作后，prev指针的移动方式是不同的
     * */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-100), prev = dummy, cur = head;
        dummy.next = head;
        while (cur != null) {
            boolean flag = false;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                prev.next = cur;
                flag = true;
            }
            cur = cur.next;
            if (flag) {
                prev.next = cur;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(deleteDuplicates(ListNode.formLinkedList("[1,2,3,3,4,4,5]")));
    }
}
