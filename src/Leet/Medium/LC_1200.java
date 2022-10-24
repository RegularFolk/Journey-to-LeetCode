package Leet.Medium;

public class LC_1200 {
    Node root;

    private static class Node {
        int x;
        int y;
        Node lc;
        Node rc;

        public Node() {
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, Node lc, Node rc) {
            this.x = x;
            this.y = y;
            this.lc = lc;
            this.rc = rc;
        }
    }

    public LC_1200() {
        root = new Node();
    }

    public boolean book(int start, int end) {
        try {
            root = add(root, start, end);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Node add(Node root, int start, int end) {
        if (root == null) {
            return new Node(start, end);
        }
        if (start >= root.y) {
            root.rc = add(root.rc, start, end);
        } else if (end <= root.x) {
            root.lc = add(root.lc, start, end);
        } else {
            throw new RuntimeException();
        }
        return root;
    }
}
