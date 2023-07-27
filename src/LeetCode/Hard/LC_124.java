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


class redo_124 {
    /*
    * 对于一个节点，如果最大的路径包含当前节点，有两种情况
    * 1 当前节点连接父节点与一个子树
    * 2 当前节点连接左右两个子树
    * 所以递归的时候向上返回只需要返回与一个子树相加的结果
    * 而当前最大值的更新需要加上左右两个子树
    * */
    public int maxPathSum(TreeNode root) {
        return 0;
    }
}
