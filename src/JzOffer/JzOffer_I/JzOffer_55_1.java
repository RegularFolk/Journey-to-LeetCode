package JzOffer.JzOffer_I;

import DataStructure.TreeNode;

public class JzOffer_55_1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
