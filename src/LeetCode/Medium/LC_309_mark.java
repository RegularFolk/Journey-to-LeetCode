package LeetCode.Medium;

public class LC_309_mark {
    /*
     * 动态规划（难点在于分析状态，确定dp数组的含义）
     * 四个状态
     *   状态一:处于买入状态
     *       ①:昨天处于冻结状态
     *       ②:昨天卖出度过冻结状态
     *       ③:昨天也是处于买入状态(一直没有动过)
     *   状态二:今天卖出
     *       之前一定处于买入状态
     *   状态三:卖出后一直不动度过冻结状态
     *       ①:前一天也是如此
     *       ②:前一天处于冻结状态
     *   状态四:今天处于冻结状态
     *       前一天一定处于卖出状态
     * 答案就是dp数组最后一个元素的二三四状态的最大值
     * */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = prices[0] * -1;//第一天买入
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3], dp[i - 1][2]) - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][3]);
            dp[i][3] = dp[i - 1][1];
        }
        return Math.max(Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]), dp[prices.length - 1][3]);
    }
}
