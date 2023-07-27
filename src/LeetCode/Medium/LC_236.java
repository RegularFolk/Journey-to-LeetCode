package LeetCode.Medium;

import DataStructure.TreeNode;

public class LC_236 {
    /*
     * DFS
     * 对于一个节点，如果两个目标节点一个在其左子树，一个在其右子树，
     * 或者一个是其本身，另一个在其子树中，该节点就是最近公共节点
     *
     * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root; // 找到其中一个节点的情况
        TreeNode findInLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode findInRight = lowestCommonAncestor(root.right, p, q);
        if (findInLeft != null && findInRight != null) return root;
        return findInLeft == null ? findInRight : findInLeft;
    }
}
