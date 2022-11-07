package LeetCode.Hard;

import DataStructure.TreeNode;

public class LC_124 {
    private int ans = Integer.MIN_VALUE;

    /*
    * 递归，但是要注意细节
    *   对每个节点，更新ans和递归返回结果时必须带上根节点
    * */
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return ans;
    }

    private int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = Math.max(0, findMax(root.left));
            int right = Math.max(0, findMax(root.right));
            ans = Math.max(ans, left + right + root.val);
            return Math.max(left, right) + root.val;
        }
    }
}
