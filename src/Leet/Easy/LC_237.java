package Leet.Easy;

import DataStructure.ListNode;

public class LC_237 {
    public static void main(String[] args) {
        //������
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
