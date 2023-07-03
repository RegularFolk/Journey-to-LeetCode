package JzOffer.JzOffer_II;

import DataStructure.TreeNode;

public class JzOfferII_054 {
    /*
     * 反过来做DFS
     * */
    private int curMax = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            root.val = root.val + curMax;
            curMax = root.val;
            convertBST(root.left);
        }
        return root;
    }
}
