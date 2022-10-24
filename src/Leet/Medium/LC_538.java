package Leet.Medium;

import DataStructure.TreeNode;

public class LC_538 {

    /*
     * ÓÒÖÐ×óË³ÐòµÝ¹é
     * */
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.right);
            sum += root.val;
            root.val = sum;
            dfs(root.left);
        }
    }
}
