package LeetCode.Medium;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_199 {
    /*
     * 右视图，即层序遍历每层的最后一个元素
     * */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int cur = 1, next = 0;
        while (q.size() > 0) {
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
                if (cur == 0) {
                    ans.add(poll.val);
                }
            }
            cur = next;
            next = 0;
        }
        return ans;
    }
}
