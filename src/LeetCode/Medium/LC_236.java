package LeetCode.Medium;

import DataStructure.TreeNode;

public class LC_236 {
    /*
     * DFS
     * ����һ���ڵ㣬�������Ŀ��ڵ�һ��������������һ��������������
     * ����һ�����䱾����һ�����������У��ýڵ������������ڵ�
     *
     * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root; // �ҵ�����һ���ڵ�����
        TreeNode findInLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode findInRight = lowestCommonAncestor(root.right, p, q);
        if (findInLeft != null && findInRight != null) return root;
        return findInLeft == null ? findInRight : findInLeft;
    }
}
