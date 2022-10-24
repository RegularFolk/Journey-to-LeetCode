package Leet.Medium;

public class LC_279_mark {
    /*
     * ��̬�滮
     * dp[i]��ʾ��Ϊi����С����
     * */
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // Ĭ�ϳ�ʼ��ֵ��Ϊ0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // ����������ÿ��+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // ��̬ת�Ʒ���
            }
        }
        return dp[n];
    }

}
