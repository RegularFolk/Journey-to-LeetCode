package Easy;

public class LC_110 {
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

    public static boolean isBalanced(TreeNode root) {
        if (root != null) {
            if (Math.abs(height(root.left) - height(root.right)) > 1) {
                return false;
            }
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return true;
    }

    public static int height(TreeNode treeNode) {
        return treeNode == null ? 0 : Math.max(height(treeNode.left), height(treeNode.right)) + 1;
    }
}
