package LeetCode.Easy;

import DataStructure.TreeNode;

public class LC_226 {
    /*
     * �ݹ�ض�ÿ���ڵ㷭ת���ҽڵ�
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
