package LeetCode.Easy;

import DataStructure.TreeNode;

public class LC_112 {
    /*
     * �����������ݵĵݹ�ģ����
     * */
    private int sum = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        sum += root.val;
        if (root.left == null && root.right == null && sum == targetSum) return true;
        boolean left = hasPathSum(root.left, targetSum);
        boolean right = hasPathSum(root.right, targetSum);
        if (left || right) return true;
        sum -= root.val;
        return false;
    }
}
