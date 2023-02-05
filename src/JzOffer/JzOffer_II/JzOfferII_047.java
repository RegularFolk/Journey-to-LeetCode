package JzOffer.JzOffer_II;

import DataStructure.TreeNode;

public class JzOfferII_047 {
    /*
    * ¶þ²æÊ÷¼ôÖ¦,µÝ¹é´¦Àí
    * */
    public TreeNode pruneTree(TreeNode root) {
        TreeNode dummy = new TreeNode();
        dummy.left = root;
        doCut(dummy);
        return dummy.left;
    }

    private boolean doCut(TreeNode node) {
        if (node == null) return true;
        boolean l, r;
        l = doCut(node.left);
        if (l) node.left = null;
        r = doCut(node.right);
        if (r) node.right = null;
        return l && r && node.val == 0;
    }
}
