package LeetCode.Medium;

import java.util.Arrays;

public class LC_322_mark {
    /*
     * 完全背包
     * dp[j]表示凑出j元所需的最少硬币
     * dp[j] = min(dp[j-coins[i]])+1,即dp[j] = min(dp[j],dp[i-coin[i]]+1)
     * */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
