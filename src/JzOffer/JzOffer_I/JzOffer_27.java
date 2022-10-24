package JzOffer.JzOffer_I;

import DataStructure.TreeNode;

public class JzOffer_27 {
    public TreeNode mirrorTree(TreeNode root) {
        mirror(root);
        return root;
    }

    private void mirror(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            if (root.left != null) {
                mirror(root.left);
            }
            if (root.right != root) {
                mirror(root.right);
            }
        }
    }

}
