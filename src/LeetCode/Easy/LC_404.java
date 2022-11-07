package LeetCode.Easy;

import DataStructure.TreeNode;

public class LC_404 {
    /*
     * ตÝน้
     * */
    int ans = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, false);
        return ans;
    }

    private void dfs(TreeNode root, boolean flag) {
        if (root != null) {
            if (root.left == null && root.right == null && flag) ans += root.val;
            dfs(root.left, true);
            dfs(root.right, false);
        }
    }
}
