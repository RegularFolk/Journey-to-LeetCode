package Hard;

import DataStructure.TreeNode;

public class LC_1373 {
    /*
     * 自底向上递归
     * */
    private int ans = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    /*
     * int[0]表示是否为BST
     * int[1]表示该子树最小节点
     * int[2]表示该子树最大节点
     * int[3]表示该子树最大和
     * */
    private int[] dfs(TreeNode root) {
        if (root != null) {
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            boolean bst = (left == null || (left[0] == 1 && left[2] < root.val)) && (right == null || (right[0] == 1 && right[1] > root.val));
            if (!bst) return new int[]{0};
            int sum = (left == null ? 0 : left[3]) + (right == null ? 0 : right[3]) + root.val;
            ans = Math.max(ans, sum);
            return new int[]{1, left == null ? root.val : left[1], right == null ? root.val : right[2], sum};
        }
        return null;//空数组表示空节点
    }
}
