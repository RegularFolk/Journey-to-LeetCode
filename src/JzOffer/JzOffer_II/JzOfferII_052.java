package JzOffer.JzOffer_II;

import DataStructure.TreeNode;

public class JzOfferII_052 {
    /*
     * 递归,自顶向下的处理思路
     * */
    private int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxValue;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftValue = dfs(root.left);
        int rightValue = dfs(root.right);
        int returnMax = Math.max(root.val,
                Math.max(root.val + leftValue, root.val + rightValue));
        maxValue = Math.max(maxValue,
                Math.max(root.val + leftValue + rightValue, returnMax));
        return returnMax;
    }
}
