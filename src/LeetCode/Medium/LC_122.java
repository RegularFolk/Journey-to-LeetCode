package LeetCode.Medium;

public class LC_122 {
    /*
     * 二维dp,带状态的动态规划，根据每一天可以进行的操作进行状态分析
     * dp[i][0]表示在第i天买入后口袋里的钱
     * dp[i][1]表示在第i天卖出后口袋里的钱
     * dp[i][2]表示第i天处于买了不动口袋里的钱
     * dp[i][3]表示第i天处于卖了不动口袋里的钱
     * */
    public int maxProfit1(int[] prices) {
        int max = 0;
        int[][] dp = new int[prices.length][4];
        dp[0][0] -= prices[0];
        dp[0][2] = dp[0][0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][3]) - prices[i];//买入
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + prices[i];//卖出
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][2]);//买了不动
            dp[i][3] = Math.max(dp[i - 1][1], dp[i - 1][3]);//卖了不动
            max = Math.max(Math.max(dp[i][1], dp[i][3]), max);
        }
        return max;
    }

    /*
     * 贪心法，只要今天比前一天大就可以卖出
     * */
    public int maxProfit2(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += Math.max(0, prices[i] - prices[i - 1]);
        }
        return sum;
    }
}

class redo_122 {
    /*
     * 任意多次卖，只要后一天价格比前一天高就可以卖
     * */
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }
}
