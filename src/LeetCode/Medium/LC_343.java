package LeetCode.Medium;

public class LC_343 {

    /*
     * dp[i] ��ʾ i ��ֳ˻�����ֵ
     * ��ʼ��dp[2] = 1
     * dp[i] = max(dp[i], dp[i-j] * j)
     * */
    public int integerBreak(int n) {
        if (n == 2) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                // �������˼�� i - j ���ܻ���� dp[i - j]
                dp[i] = Math.max(Math.max((i - j) * j, dp[i - j] * j), dp[i]);
            }
        }
        return dp[n];
    }
}
