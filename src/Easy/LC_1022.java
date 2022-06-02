package Easy;

import java.util.Objects;

public class LC_1022 {
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

    public int sumRootToLeaf(TreeNode root) {
        return travel(root, 0);
    }

    private int travel(TreeNode root, int i) {
        i = (i << 1) + root.val;
        if (root.left == null && root.right == null) {
            return i;
        } else {
            if (root.left != null && root.right != null) {
                return travel(root.left, i) + travel(root.right, i);
            } else return travel(Objects.requireNonNullElseGet(root.left, () -> root.right), i);
        }
    }
}
