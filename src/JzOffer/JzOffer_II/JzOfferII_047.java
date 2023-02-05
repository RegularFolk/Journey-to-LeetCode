package JzOffer.JzOffer_II;

import DataStructure.TreeNode;

public class JzOfferII_047 {
    /*
    * ��������֦,�ݹ鴦��
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
