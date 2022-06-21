package JzOffer;

import java.util.Stack;

public class JzOffer_052 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode ans = new TreeNode();
        TreeNode dummy = ans;
        TreeNode cursor = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cursor != null || !stack.empty()) {
            if (cursor == null) {
                dummy.right = new TreeNode(stack.peek().val);
                dummy = dummy.right;
                cursor = stack.pop().right;
            } else if (cursor.left != null) {
                stack.push(cursor);
                cursor = cursor.left;
            } else if (cursor.right != null) {
                dummy.right = new TreeNode(cursor.val);
                dummy = dummy.right;
                cursor = cursor.right;
            } else {
                dummy.right = new TreeNode(cursor.val);
                if (stack.empty()) {
                    break;
                } else {
                    cursor = stack.peek().right;
                    dummy.right.right = new TreeNode(stack.pop().val);
                    dummy = dummy.right.right;
                }
            }
        }
        return ans.right;
    }

//    public static TreeNode m(TreeNode root, TreeNode left, TreeNode right) {
//        if (root != null) {
//
//        }
//    }
}
