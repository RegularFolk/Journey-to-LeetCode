package Leet.Medium;

import DataStructure.TreeNode;

public class LC_687 {
    private int ans = 0;

    /*
     * 路径，注意更新ans和返回递归调用的不是一种情况
     * */
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val);
        return Math.max(ans - 1, 0);
    }

    private int dfs(TreeNode root, int val) {
        if (root != null) {
            int left = dfs(root.left, root.val);
            int right = dfs(root.right, root.val);
            int len = 1 + left + right;
            ans = Math.max(ans, len);
            if (root.val == val) return 1 + Math.max(left, right);
        }
        return 0;
    }
}
