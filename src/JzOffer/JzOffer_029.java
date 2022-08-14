package JzOffer;

import DataStructure.Node;

public class JzOffer_029 {
//    public Node insert1(Node he, int x) {
//        Node t = new Node(x);
//        t.next = t;
//        if (he == null) return t;
//        Node ans = he;
//        int min = he.val, max = he.val;
//        while (he.next != ans) {
//            he = he.next;
//            min = Math.min(min, he.val);
//            max = Math.max(max, he.val);
//        }
//        if (min == max) {
//            t.next = ans.next;
//            ans.next = t;
//        } else {
//            while (!(he.val == max && he.next.val == min)) he = he.next;
//            while (!(x <= min || x >= max) && !(he.val <= x && x <= he.next.val)) he = he.next;
//            t.next = he.next;
//            he.next = t;
//        }
//        return ans;
//    }
//
//    public Node insert(Node head, int insertVal) {
//        Node rec = head, ins = new Node(insertVal);
//        ins.next = ins;
//        if (head == null || head.next == null) {
//            return ins;
//        }
//        int max = head.val, min = head.val;
//        while (head.next != rec) {
//            head = head.next;
//            max = Math.max(max, head.val);
//            min = Math.min(min, head.val);
//        }
//        if (min == max) {
//            ins.next = head.next;
//            head.next = ins;
//        } else {
//            while (!(head.val == max && head.next.val == min)) {
//                head = head.next;
//            }
//            while (!(insertVal <= min || insertVal >= max) && !(head.val <= insertVal && insertVal <= head.next.val)) {
//                head = head.next;
//            }
//            ins.next = head.next;
//            head.next = ins;
//        }
//        return rec;
//    }
}
