package LeetCode.Medium;

import DataStructure.TreeNode;
import org.junit.Test;

public class LC_1008 {
    /*
     * 递归处理
     * 不断插入即可
     * */
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }
        return root;
    }

    private TreeNode insert(TreeNode root, int i) {
        if (root == null) return new TreeNode(i);
        if (i < root.val) {
            root.left = insert(root.left, i);
        } else {
            root.right = insert(root.right, i);
        }
        return root;
    }


    @Test
    public void x() {
        TreeNode treeNode = bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        System.out.println(treeNode);
    }
}
