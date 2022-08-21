package CrackCodeInterview;

import DataStructure.TreeNode;

public class Interview_04_04 {
    public boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }

    private int check(TreeNode root) { //利用-1标记失败避免重复计算
        if (root == null) {
            return 0;
        }
        int left = check(root.left), right = check(root.right);
        return left == -1 || right == -1 || Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}
