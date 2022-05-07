package Easy;

public class LC_563 {

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

    public static int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int current;
            if (root.left != null || root.right != null) {
                current = Math.abs(sum(root.left) - sum(root.right));
                return current + findTilt(root.left) + findTilt(root.right);
            } else {
                return 0;
            }
        }
    }

    public static int sum(TreeNode root) {         //树所有元素之和
        if (root != null) {
            return root.val + sum(root.left) + sum(root.right);
        } else {
            return 0;
        }
    }

}
