package Leet.Medium;

import DataStructure.TreeNode;

public class LC_1379 {
    /*
     * ²»ÖªËùÔÆ
     * */
    private TreeNode ans = null;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs(cloned, target);
        return ans;
    }

    private void dfs(TreeNode cloned, TreeNode target) {
        if (cloned != null) {
            if (cloned.val == target.val) ans = cloned;
            else {
                dfs(cloned.left, target);
                dfs(cloned.right, target);
            }
        }
    }
}
