package Easy;

public class LC_101 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isSame(root.left, root.right);
        }
    }

    public static boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if ((left == null || right == null) || left.val != right.val) {
            return false;
        } else {
            return isSame(left.left, right.right) && isSame(left.right, right.left);
        }
    }
}
