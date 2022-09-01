package Medium;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class LC_337 {
    /*
     * 二叉树的层序遍历,求出逐层的和之后用动态规划?
     * 错误
     * */
    public int rob1(TreeNode root) {
        if (root == null) return 0;
        int cur = 1, next = 0;
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        while (q.size() > 0) {
            int sum = 0;
            while (cur-- > 0) {
                TreeNode first = q.removeFirst();
                sum += first.val;
                if (first.left != null) {
                    q.addLast(first.left);
                    next++;
                }
                if (first.right != null) {
                    q.addLast(first.right);
                    next++;
                }
            }
            cur = next;
            next = 0;
            list.add(sum);
        }
        return getMax(list);
    }

    private int getMax(ArrayList<Integer> list) {
        int[] dp = new int[list.size()];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i - 2; j >= 0; j--) {
                dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] += list.get(i);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /*
     * 从递归的角度分析
     * 如果选择了当前节点，则不能选取左右子树，否则尝试左右子树
     * */
    public int rob2(TreeNode root) {
        return 0;
    }
}
