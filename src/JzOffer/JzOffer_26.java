package JzOffer;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;


public class JzOffer_26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        List<TreeNode> tar = new LinkedList<>();//存在相等的，所以找出全部
        find(A, B, tar);
        for (TreeNode node : tar) {
            if (confirm(node, B)) {
                return true;
            }
        }
        return false;
    }

    private boolean confirm(TreeNode tar, TreeNode b) {
        if (b == null) {
            return true;
        } else if (tar == null) {
            return false;
        } else if (tar.val == b.val) {
            return confirm(tar.left, b.left) && confirm(tar.right, b.right);
        }
        return false;
    }

    private void find(TreeNode a, TreeNode b, List<TreeNode> tar) {//找到a中所有与b值相等的节点
        if (a.val == b.val) {
            tar.add(a);
        }
        if (a.left != null) {
            find(a.left, b, tar);
        }
        if (a.right != null) {
            find(a.right, b, tar);
        }
    }
}
