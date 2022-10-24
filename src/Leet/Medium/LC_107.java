package Leet.Medium;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_107 {
    /*
     * 二叉树自底向上的层序遍历
     * */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int cur = 1, next = 0;
        while (q.size() > 0) {
            List<Integer> add = new ArrayList<>();
            while (cur-- > 0) {
                TreeNode poll = q.poll();
                if (poll.left != null) {
                    q.add(poll.left);
                    next++;
                }
                if (poll.right != null) {
                    q.add(poll.right);
                    next++;
                }
                add.add(poll.val);
            }
            ans.addFirst(add);
            cur = next;
            next = 0;
        }
        return ans;
    }
}
