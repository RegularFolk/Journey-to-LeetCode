package LeetCode.Easy;

import java.util.List;

public class LC_599 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else {
            int height = 0;
            for (Node node : root.children) {
                height = Math.max(height, maxDepth(node));
            }
            return height + 1;
        }
    }
}
