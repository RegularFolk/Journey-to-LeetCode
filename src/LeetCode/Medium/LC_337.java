package LeetCode.Medium;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
     * 超时，需要优化
     * */
    public int rob2(TreeNode root) {
        return Math.max(steal(root, true), steal(root, false));
    }

    private int steal(TreeNode root, boolean b) {
        if (root == null) return 0;
        if (b) {//当前这个节点偷,左右子树一定不偷
            return root.val + steal(root.left, false) + steal(root.right, false);
        } else {//当前这个节点不偷，左右子树不一定偷
            int p1 = steal(root.left, true) + steal(root.right, true);
            int p2 = steal(root.left, false) + steal(root.right, false);
            int p3 = steal(root.left, true) + steal(root.right, false);
            int p4 = steal(root.left, false) + steal(root.right, true);
            return Math.max(Math.max(Math.max(p1, p2), p3), p4);
        }
    }

    /*
     * 记忆化递归，利用map记录当前节点偷与不偷分别对应的最大值
     * */
    private final Map<TreeNode, Integer> trueMap = new HashMap<>();
    private final Map<TreeNode, Integer> falseMap = new HashMap<>();

    public int rob3(TreeNode root) {
        return Math.max(steal1(root, true), steal1(root, false));
    }

    private int steal1(TreeNode root, boolean b) {
        if (root == null) return 0;
        if (b) {//当前这个节点偷,左右子树一定不偷
            Integer mapValue = trueMap.getOrDefault(root, -1);
            if (mapValue != -1) {
                return mapValue;
            } else {
                int max = root.val + steal1(root.left, false) + steal1(root.right, false);
                trueMap.put(root, max);
                return max;
            }
        } else {//当前这个节点不偷，左右子树不一定偷
            Integer integer = falseMap.getOrDefault(root, -1);
            if (integer != -1) {
                return integer;
            } else {
                int p1 = steal1(root.left, true) + steal1(root.right, true);
                int p2 = steal1(root.left, false) + steal1(root.right, false);
                int p3 = steal1(root.left, true) + steal1(root.right, false);
                int p4 = steal1(root.left, false) + steal1(root.right, true);
                int max = Math.max(Math.max(Math.max(p1, p2), p3), p4);
                falseMap.put(root, max);
                return max;
            }
        }
    }
}
