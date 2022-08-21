package CrackCodeInterview;

import DataStructure.ListNode;

public class Interview_02_03 {
    public void deleteNode(ListNode node) {//替身大法
        node.val = node.next.val;
        if (node.next.next == null) {
            node.next = null;
        } else {
            deleteNode(node.next);
        }
    }
}
