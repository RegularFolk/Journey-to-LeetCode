package Leet.Easy;

import DataStructure.TreeNode;

public class LC_101 {

    public boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if ((left == null || right == null) || left.val != right.val) {
            return false;
        } else {
            return isSame(left.left, right.right) && isSame(left.right, right.left);
        }
    }
}
