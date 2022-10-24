package JzOffer.JzOffer_II;

import DataStructure.TreeNode;

public class JzOfferII_053 {
    /*
     * 二叉搜索树的中序后继
     * 维护prev节点
     * */
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root != null) {
            TreeNode left = inorderSuccessor(root.left, p);
            if (left != null) return left;
            if (prev.val == p.val) return root;
            prev = root;
            return inorderSuccessor(root.right, p);
        }
        return null;
    }
}
