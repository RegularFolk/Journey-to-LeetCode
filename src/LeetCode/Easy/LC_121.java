package LeetCode.Easy;

public class LC_121 {
    /*
    * 从后往前遍历，维护最大值，对每个遍历到的值作差与之前结果取最大值
    * */
    public int maxProfit(int[] prices) {
        int max = 0, highest = -1;
        for (int i = prices.length - 1; i >= 0; i--) {
            highest = Math.max(highest, prices[i]);
            max = Math.max(max, highest - prices[i]);
        }
        return max;
    }
}
