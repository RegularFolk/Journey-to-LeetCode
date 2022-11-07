package LeetCode.Hard;

import DataStructure.TreeNode;

public class LC_124 {
    private int ans = Integer.MIN_VALUE;

    /*
    * �ݹ飬����Ҫע��ϸ��
    *   ��ÿ���ڵ㣬����ans�͵ݹ鷵�ؽ��ʱ������ϸ��ڵ�
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
