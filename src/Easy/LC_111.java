package Easy;

public class LC_111 {
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

    public static int minDepth(TreeNode root) {
        if (root != null) {
            if (root.left == null && root.right != null) {
                return minDepth(root.right) + 1;
            } else if (root.left != null && root.right == null) {
                return minDepth(root.left) + 1;
            } else if (root.left != null) {
                return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }

}
