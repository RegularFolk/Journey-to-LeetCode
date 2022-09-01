package Medium;

import DataStructure.TreeNode;

public class LC_998 {
    /*
    * LC_654�ĺ���
    * ����������ĵݹ鴦��
    * */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) {
            TreeNode treeNode = new TreeNode(val);
            treeNode.left = root;
            return treeNode;
        } else {
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
    }
}
