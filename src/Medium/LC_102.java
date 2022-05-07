package Medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class LC_102 {
    public static void main(String[] args) {
//¶þ²æÊ÷µÄ²ãÐò±éÀú
    }

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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        int count = 1;
        int temp;
        Queue<TreeNode> queue = new ConcurrentLinkedDeque<>();
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        queue.add(root);
        while (count > 0) {
            LinkedList<Integer> insert = new LinkedList<>();
            temp = 0;
            for (int i = 0; i < count; i++) {
                if (queue.element().left != null) {
                    queue.add(queue.peek().left);
                    temp++;
                }
                if (queue.element().right != null) {
                    queue.add(queue.peek().right);
                    temp++;
                }
                if (queue.peek() != null) {
                    insert.add(queue.poll().val);
                }
            }
            count = temp;
            ans.add(insert);
        }
        return ans;
    }
}
