package Leet.Medium;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LC_113 {
    /*
     * DFS
     * */
    private final List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0, new LinkedList<>());
        return ans;
    }

    private void dfs(TreeNode root, int targetSum, int curSum, LinkedList<Integer> path) {
        if (root != null) {
            path.addLast(root.val);
            if (root.left == null && root.right == null && curSum + root.val == targetSum) {
                ans.add(List.copyOf(path));
            } else {
                dfs(root.left, targetSum, curSum + root.val, path);
                dfs(root.right, targetSum, curSum + root.val, path);
            }
            path.removeLast();
        }
    }
}
