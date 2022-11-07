package LeetCode.Medium;

import DataStructure.Node;

public class LC_116_mark {
    /*
     * 递归处理，另每一个节点的左儿子指向右儿子
     * 同时，由于在上一层已经把本节点的next处理好了，便可以把右儿子指向next的左儿子
     * 巧妙
     * */
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
