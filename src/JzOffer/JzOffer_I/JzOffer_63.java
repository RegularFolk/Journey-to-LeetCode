package JzOffer.JzOffer_I;

public class JzOffer_63 {
    public int maxProfit1(int[] prices) {  //维护差值，找最大子序列和
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int[] diff = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            diff[i - 1] = prices[i] - prices[i - 1];
        }
        int ans = 0, cur = 0;
        for (int j : diff) {
            cur += j;
            ans = Math.max(ans, cur);
            if (cur <= 0) {
                cur = 0;
            }
        }
        return ans;
    }

    public int maxProfit2(int[] prices) { //法二，一次遍历,对于任意一天，维护此前最小值，便可得知若当天卖出的最大收益，维护各个最大收益
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE, gain = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            gain = Math.max(gain, price - min);
        }
        return gain;
    }
}
