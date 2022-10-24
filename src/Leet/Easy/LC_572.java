package Leet.Easy;

import DataStructure.TreeNode;

public class LC_572 {
    /*
     * �ж϶������Ƿ�Ϊ��һ���������ĺ��
     * �ݹ��ж�
     * */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;
        if (root.val == subRoot.val) {
            if (check(root, subRoot)) return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        return root.val == subRoot.val && check(root.left, subRoot.left) && check(root.right, subRoot.right);
    }
}
