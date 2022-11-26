package JzOffer.JzOffer_II;

import DataStructure.Node;

public class JzOfferII_029 {
    public Node insert(Node head, int insertVal) {
        Node rec = head, ins = new Node(insertVal);
        ins.next = ins;
        if (head == null || head.next == null) {
            return ins;
        }
        int max = head.val, min = head.val;
        while (head.next != rec) {
            head = head.next;
            max = Math.max(max, head.val);
            min = Math.min(min, head.val);
        }
        if (min != max) {
            while (!(head.val == max && head.next.val == min)) {
                head = head.next;
            }
            while (!(insertVal <= min || insertVal >= max) && !(head.val <= insertVal && insertVal <= head.next.val)) {
                head = head.next;
            }
        }
        ins.next = head.next;
        head.next = ins;
        return rec;
    }
}
