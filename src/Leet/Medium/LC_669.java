package Leet.Medium;

import DataStructure.TreeNode;

public class LC_669 {
    /*
     * 利用BST的性质
     * 如果一个节点小于low，该节点所有左子孙也小于low
     * 如果一个节点大于high，该节点所有右子孙也大于high
     * 开始时加上根节点符合题意，最后再做判断
     * 注意细节
     * */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        preOrder(root, low, high);
        while (root != null && root.val < low) root = root.right;
        while (root != null && root.val > high) root = root.left;
        return root;
    }

    private void preOrder(TreeNode root, int low, int high) {
        if (root != null) {
            while (root.left != null && root.left.val < low) root.left = root.left.right;
            while (root.right != null && root.right.val > high) root.right = root.right.left;
            preOrder(root.left, low, high);
            preOrder(root.right, low, high);
        }
    }
}
