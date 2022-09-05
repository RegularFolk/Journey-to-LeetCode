package Medium;

public class LC_518 {
    /*
     * 完全背包
     * dp[j]表示金额为j有dp[j]种组合
     * dp[j]为所有的dp[j-coins[i]]相加
     *
     * 直观上理解，类似于走楼梯
     * */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
