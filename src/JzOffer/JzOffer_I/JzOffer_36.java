package JzOffer.JzOffer_I;

import java.util.LinkedList;
import java.util.List;

public class JzOffer_36 {
    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private final List<Node> list = new LinkedList<>();
    private Node cursor = new Node();

//    @Test
//    public void test() {
//        outPrint(treeToDoublyList(new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5))));
//    }
//
//    public void outPrint(Node root) {
//        while (root != null) {
//            System.out.println("root.val = " + root.val);
//            root = root.right;
//        }
//    }

    public Node treeToDoublyList1(Node root) { //直接中序遍历然后重塑指针,比法一要慢
        if (root == null) {
            return null;
        }
        midTravel(root);
        doList1();
        Node min = list.get(0);
        Node max = list.get(list.size() - 1);
        min.left = max;
        max.right = min;
        return min;
    }

    private void doList1() {
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
    }

    private void midTravel(Node root) {
        if (root.left != null) {
            midTravel(root.left);
        }
        list.add(root);
        if (root.right != null) {
            midTravel(root.right);
        }
    }


    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node min = findMin(root);
        Node max = findMax(root);
        transform(root);
        doList(list);
        min.left = max;  //还要求首尾相连
        max.right = min;
        return min;
    }

    private void doList(List<Node> list) {
        for (Node node : list) {
            if (node.left != null && node.left.right == null) {
                node.left.right = node;
            }
            if (node.right != null && node.right.left == null) {
                node.right.left = node;
            }
        }
    }

    private void transform(Node root) {
        Node left = root.left, right = root.right;
        list.add(root);
        if (left != null) {
            root.left = findMax(left);
            transform(left);
        }
        if (right != null) {
            root.right = findMin(right);
            transform(right);
        }
    }

    private Node findMin(Node root) {
        return root.left == null ? root : findMin(root.left);
    }

    private Node findMax(Node root) {
        return root.right == null ? root : findMax(root.right);
    }
}
