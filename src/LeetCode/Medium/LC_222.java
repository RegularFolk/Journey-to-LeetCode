package LeetCode.Medium;

import DataStructure.TreeNode;

public class LC_222 {
    /*
     * 完全二叉树与计数
     * */
    private int ans = 0;

    public int countNodes(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            ans++;
            dfs(root.left);
            dfs(root.right);
        }
    }
}
