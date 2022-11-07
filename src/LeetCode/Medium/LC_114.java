package LeetCode.Medium;

import DataStructure.TreeNode;

public class LC_114 {
    /*
    * �ݹ飬��ÿһ���ڵ㣬�ȱ�������������������ֵΪ���������������ÿգ�
    *   �ݹ������������Ȼ����ʼ�������������ӵ�β�����ٵݹ�
    * �ռ临�Ӷ�1(���Եݹ�����)
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
