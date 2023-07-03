package JzOffer.JzOffer_II;

import DataStructure.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class JzOfferII_056 {
    /*
     * 简单的set的应用
     * */
    private final Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
