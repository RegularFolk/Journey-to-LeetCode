package CrackCodeInterview.II_LinkedList;

import DataStructure.ListNode;

public class Interview_02_01 {
    public ListNode removeDuplicateNodes1(ListNode head) { //使用辅助空间，开一个数组做哈希，若不使用辅助空间，只能 n^2 爆拽
        if (head == null) {
            return null;
        }
        boolean[] hash = new boolean[20001];
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (dummy.next != null) {
            if (!hash[dummy.next.val]) {
                hash[dummy.next.val] = true;
                dummy = dummy.next;
            } else {
                dummy.next = dummy.next.next;
            }
        }
        return head;
    }

}
