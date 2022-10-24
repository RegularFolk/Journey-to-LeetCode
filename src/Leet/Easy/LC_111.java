package Leet.Easy;

import DataStructure.TreeNode;

public class LC_111 {

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
