package LeetCode.Medium;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        int current = 1, next = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (current != 0 || next != 0) {
            int max = queue.peek().val;
            while (current-- > 0) {
                if (queue.peek().left != null) {
                    queue.add(queue.peek().left);
                    next++;
                }
                if (queue.peek().right != null) {
                    queue.add(queue.peek().right);
                    next++;
                }
                max = Math.max(max, queue.poll().val);
            }
            current = next;
            next = 0;
            ans.add(max);
        }
        return ans;
    }
}
