package LeetCode.Medium;

import DataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LC_437 {
    /*
     * 前缀和
     * 全部用Long处理溢出
     * */
    private int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        dfs(root, (long) targetSum, map, 0L);
        return ans;
    }

    private void dfs(TreeNode root, Long targetSum, Map<Long, Long> map, Long curSum) {
        if (root != null) {
            curSum += root.val;
            long required = curSum - targetSum;
            ans += map.getOrDefault(required, 0L);
            Long cueSumCount = map.getOrDefault(curSum, 0L);
            map.put(curSum, cueSumCount + 1);
            dfs(root.left, targetSum, map, curSum);
            dfs(root.right, targetSum, map, curSum);
            map.put(curSum, cueSumCount);
        }
    }
}
