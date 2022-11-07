package LeetCode.Medium;

public class LC_309_mark {
    /*
     * ��̬�滮���ѵ����ڷ���״̬��ȷ��dp����ĺ��壩
     * �ĸ�״̬
     *   ״̬һ:��������״̬
     *       ��:���촦�ڶ���״̬
     *       ��:���������ȹ�����״̬
     *       ��:����Ҳ�Ǵ�������״̬(һֱû�ж���)
     *   ״̬��:��������
     *       ֮ǰһ����������״̬
     *   ״̬��:������һֱ�����ȹ�����״̬
     *       ��:ǰһ��Ҳ�����
     *       ��:ǰһ�촦�ڶ���״̬
     *   ״̬��:���촦�ڶ���״̬
     *       ǰһ��һ����������״̬
     * �𰸾���dp�������һ��Ԫ�صĶ�����״̬�����ֵ
     * */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = prices[0] * -1;//��һ������
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3], dp[i - 1][2]) - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][3]);
            dp[i][3] = dp[i - 1][1];
        }
        return Math.max(Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]), dp[prices.length - 1][3]);
    }
}
