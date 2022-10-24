package JzOffer.JzOffer_I;

import DataStructure.Node;

public class JzOffer_35 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = head;
        while (dummy != null) {
            Node node = new Node(dummy.val);
            node.next = dummy.next;
            dummy.next = node;
            dummy = node.next;
        }
        dummy = head;
        while (dummy != null) {
            dummy.next.random = dummy.random == null ? null : dummy.random.next;
            dummy = dummy.next.next;
        }
        dummy = head;
        Node ans = head.next;
        while (dummy.next.next != null) { //需要复原原先链表
            Node next = dummy.next.next;
            dummy.next.next = next.next;
            dummy.next = next;
            dummy = next;
        }
        dummy.next = null;  //处理原先链表的尾巴
        return ans;         //提交会校验原先链表
    }
}
