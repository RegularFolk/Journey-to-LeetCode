package Leet.Easy;

import DataStructure.TreeNode;

public class LC_543 {
    /*
     * µ›πÈ¥¶¿Ì
     * */
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        count(root);
        return ans - 1;
    }

    private int count(TreeNode root) {
        if (root != null) {
            int left = count(root.left);
            int right = count(root.right);
            ans = Math.max(ans, 1 + left + right);
            return Math.max(1 + left, 1 + right);
        }
        return 0;
    }
}
