package JzOffer;

import DataStructure.TreeNode;

public class JzOffer_07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        //前序遍历的preStart是根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preStart == preEnd) {
            if (inStart == inEnd) {//递归到底了
                return root;
            } else {
                throw new RuntimeException("非法序列!");
            }
        }

        //在中序遍历中找到根节点
        int cursor = inStart;
        while (cursor <= inEnd && inorder[cursor] != rootVal) {
            cursor++;
        }
        if (cursor <= inEnd && inorder[cursor] != rootVal) {
            throw new RuntimeException("非法序列!");
        }
        int leftLen = cursor - inStart, rightLen = inEnd - cursor;//左右子树的长度
        if (leftLen > 0) {
            //构建左子树
            root.left = construct(preorder, preStart + 1, preStart + leftLen, inorder, inStart, inStart + leftLen - 1);
        }
        if (rightLen > 0) {
            //构建右子树
            root.right = construct(preorder, preStart + leftLen + 1, preStart + leftLen + rightLen, inorder, cursor + 1, inEnd);
        }
        return root;
    }
}
