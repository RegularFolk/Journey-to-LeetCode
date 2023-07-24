package LeetCode.Medium;

public class LC_122 {
    /*
     * ��άdp,��״̬�Ķ�̬�滮������ÿһ����Խ��еĲ�������״̬����
     * dp[i][0]��ʾ�ڵ�i�������ڴ����Ǯ
     * dp[i][1]��ʾ�ڵ�i��������ڴ����Ǯ
     * dp[i][2]��ʾ��i�촦�����˲����ڴ����Ǯ
     * dp[i][3]��ʾ��i�촦�����˲����ڴ����Ǯ
     * */
    public int maxProfit1(int[] prices) {
        int max = 0;
        int[][] dp = new int[prices.length][4];
        dp[0][0] -= prices[0];
        dp[0][2] = dp[0][0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][3]) - prices[i];//����
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + prices[i];//����
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][2]);//���˲���
            dp[i][3] = Math.max(dp[i - 1][1], dp[i - 1][3]);//���˲���
            max = Math.max(Math.max(dp[i][1], dp[i][3]), max);
        }
        return max;
    }

    /*
     * ̰�ķ���ֻҪ�����ǰһ���Ϳ�������
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
     * ����������ֻҪ��һ��۸��ǰһ��߾Ϳ�����
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
