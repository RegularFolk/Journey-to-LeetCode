package Leet.Medium;

import DataStructure.TreeNode;

public class LC_669 {
    /*
     * ����BST������
     * ���һ���ڵ�С��low���ýڵ�����������ҲС��low
     * ���һ���ڵ����high���ýڵ�����������Ҳ����high
     * ��ʼʱ���ϸ��ڵ�������⣬��������ж�
     * ע��ϸ��
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
