package Medium;

public class LC_518 {
    /*
     * ��ȫ����
     * dp[j]��ʾ���Ϊj��dp[j]�����
     * dp[j]Ϊ���е�dp[j-coins[i]]���
     *
     * ֱ������⣬��������¥��
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
