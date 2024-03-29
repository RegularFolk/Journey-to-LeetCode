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

class redo {

    /*
     * dp[i] 表示抵达i层的最小花费
     * dp[i] = dp[i-1] + cost[i-1] or dp[i-2] + cost[i-2]
     * 依赖前两个值，依旧可以使用滚动数组
     * */
    public int minCostClimbingStairs(int[] cost) {
        // 从高度为3开始
        int a = 0, b = 0, c = 0;
        for (int i = 2; i <= cost.length; i++) {
            c = Math.min(a + cost[i - 2], b + cost[i - 1]);
            a = b;
            b = c;
        }
        return c;
    }


}
