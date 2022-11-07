package LeetCode.Easy;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_637 {
    /*
     * 层序遍历求每一层的平均值
     * */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int cur = 1, next = 0;
        while (q.size() > 0) {
            double count = cur, sum = 0;
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
                sum += poll.val;
            }
            ans.add(sum / count);
            cur = next;
            next = 0;
        }
        return ans;
    }
}
