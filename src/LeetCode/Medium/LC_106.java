package LeetCode.Medium;

import DataStructure.TreeNode;

public class LC_106 {
    /*
     * 根据中序和后序遍历构建二叉树
     * */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int iLeft, int iRight, int[] postorder, int pLeft, int pRight) {
        if (iLeft > iRight || pLeft > pRight || iLeft < 0 || pLeft < 0) return null;
        if (iLeft == iRight) return new TreeNode(inorder[iLeft]);
        TreeNode treeNode = new TreeNode(postorder[pRight]);
        int pos = -1;
        for (int i = iLeft; i <= iRight; i++) {
            if (inorder[i] == treeNode.val) {
                pos = i;
                break;
            }
        }
        int rightLen = iRight - pos;
        treeNode.right = build(inorder, pos + 1, iRight, postorder, pRight - rightLen, pRight - 1);
        treeNode.left = build(inorder, iLeft, pos - 1, postorder, pLeft, pRight - rightLen - 1);
        return treeNode;
    }
}
