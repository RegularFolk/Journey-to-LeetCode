package JzOffer.JzOffer_II;

import DataStructure.TreeNode;

import java.util.Stack;

public class JzOfferII_055 {
    /*
     * 二叉树的迭代器,一个简单的实现是将二叉树展开
     * 优化的方法，next和hasNext方法均摊时间复杂度O(1)，空间复杂度O(h)
     * 利用栈
     * */
    static class BSTIterator {

        private final Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            put(root);
        }

        private void put(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode pop = stack.pop();
            put(pop.right);
            return pop.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
