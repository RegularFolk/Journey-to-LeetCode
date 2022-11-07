package LeetCode.Easy;

import DataStructure.TreeNode;

public class LC_226 {
    /*
     * 递归地对每个节点翻转左右节点
     * */
    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    private void reverse(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            root.left = root.right;
            root.right = left;
            reverse(root.left);
            reverse(root.right);
        }
    }
}
