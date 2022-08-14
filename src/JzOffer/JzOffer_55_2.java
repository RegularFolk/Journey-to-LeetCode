package JzOffer;

import DataStructure.TreeNode;

public class JzOffer_55_2 {
    public boolean isBalanced1(TreeNode root) { //复杂度较高
        return root == null || isBalanced1(root.left) && Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced1(root.right);
    }

    private int height(TreeNode root) {
        return root == null ? 0 : Math.max(height(root.left), height(root.right)) + 1;
    }

    public boolean isBalanced2(TreeNode root) { //利用后序遍历，利用-1表示false来剪枝
        return check(root) != -1;
    }

    private int check(TreeNode root) { //-1表示不平衡，否则返回高度
        if (root == null) {
            return 0;
        }
        int left = check(root.left);
        if (left == -1) {
            return -1;
        }
        int right = check(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
