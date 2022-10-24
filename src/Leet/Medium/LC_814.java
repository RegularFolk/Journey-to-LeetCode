package Leet.Medium;

import DataStructure.TreeNode;

public class LC_814 {
    /*
     * ¶þ²æÊ÷¼ôÖ¦ DFS ºóÐò±éÀú
     * */
    public TreeNode pruneTree(TreeNode root) {
        dfs(root);
        return root.val == -1 ? null : root;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            dfs(root.right);
            if (root.left != null && root.left.val == -1) root.left = null;
            if (root.right != null && root.right.val == -1) root.right = null;
            if (root.val == 0 && root.left == null && root.right == null) root.val = -1;
        }
    }
}
