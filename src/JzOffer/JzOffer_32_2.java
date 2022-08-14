package JzOffer;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JzOffer_32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> ans = new LinkedList<>();
        int count = 1;
        while (queue.size() > 0) {
            int nextLayer = 0;
            List<Integer> add = new LinkedList<>();
            while (count > 0) {
                TreeNode peek = queue.peek();
                if (peek.left != null) {
                    queue.add(peek.left);
                    nextLayer++;
                }
                if (peek.right != null) {
                    queue.add(peek.right);
                    nextLayer++;
                }
                add.add(queue.poll().val);
                count--;
            }
            ans.add(add);
            count = nextLayer;
        }
        return ans;
    }
}
