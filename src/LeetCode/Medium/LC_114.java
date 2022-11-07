package LeetCode.Medium;

import DataStructure.TreeNode;

public class LC_114 {
    /*
    * 递归，对每一个节点，先保留右子树，右子树赋值为左子树，左子树置空，
    *   递归调用右子树，然后把最开始保留的右子树加到尾部，再递归
    * 空间复杂度1(忽略递归消耗)
    * */
    public void flatten(TreeNode root) {
        if (root != null) {
            doFlatten(root);
        }
    }

    private TreeNode doFlatten(TreeNode root) {
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        if (root.right != null) {
            TreeNode flatten = doFlatten(root.right);
            if (right != null) {
                flatten.right = right;
                return doFlatten(flatten.right);
            } else {
                return flatten;
            }
        } else {
            root.right = right;
            return right == null ? root : doFlatten(right);
        }
    }
}
