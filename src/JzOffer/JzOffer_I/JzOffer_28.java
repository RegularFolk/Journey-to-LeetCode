package JzOffer.JzOffer_I;

import DataStructure.TreeNode;

public class JzOffer_28 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || check(root.right, root.left);
    }

    private boolean check(TreeNode right, TreeNode left) {
        if (right == null && left == null) {
            return true;
        } else if (right == null || left == null) {
            return false;
        } else {
            return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
        }
    }
}
