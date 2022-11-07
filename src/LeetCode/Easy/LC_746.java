package LeetCode.Easy;

public class LC_746 {
    /*
     * 贪心
     * dp[i]表示抵达第i层的最小花费
     * dp[i] = min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
     * */
    public int minCostClimbingStairs1(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length - 1];
    }

    /*
     * 使用滚动数组优化空间，只需考虑前两个
     * */
    public int minCostClimbingStairs2(int[] cost) {
        int prev1 = 0, prev2 = 0;
        for (int i = 2; i <= cost.length; i++) {
            int cur = Math.min(prev1 + cost[i - 1], prev2 + cost[i - 2]);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
