package JzOffer.JzOffer_II;

import DataStructure.TreeNode;

import java.util.Stack;

public class JzOfferII_055 {
    /*
     * �������ĵ�����,һ���򵥵�ʵ���ǽ�������չ��
     * �Ż��ķ�����next��hasNext������̯ʱ�临�Ӷ�O(1)���ռ临�Ӷ�O(h)
     * ����ջ
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
