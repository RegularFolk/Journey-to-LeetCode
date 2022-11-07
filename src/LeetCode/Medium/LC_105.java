package LeetCode.Medium;

import DataStructure.TreeNode;

public class LC_105 {
    /*
     * 同JzOffer_7
     * */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd && inStart == inEnd) {
            return root;
        }
        int rootInorder = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                rootInorder = i;
                break;
            }
        }
        int leftLen = rootInorder - inStart, rightLen = inEnd - rootInorder;
        if (leftLen > 0) {
            root.left = build(preorder, preStart + 1, preStart + leftLen, inorder, inStart, rootInorder - 1);
        }
        if (rightLen > 0) {
            root.right = build(preorder, preStart + leftLen + 1, preEnd, inorder, rootInorder + 1, inEnd);
        }
        return root;
    }
}
