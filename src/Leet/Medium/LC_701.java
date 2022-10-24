package Leet.Medium;

import DataStructure.TreeNode;

public class LC_701 {
    /*
     * �����������Ĳ���
     * */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);
        return root;
    }
}
