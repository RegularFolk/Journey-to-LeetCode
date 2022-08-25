package CrackCodeInterview.XVII_Hard;

public class Interview_17_09_mark {
    /*
     * 与JzOffer_49 丑数原理相同
     * 把握新的丑数是由旧的丑数生成的
     * */
    public int getKthMagicNumber(int k) {
        int[] base = {1, 3, 5, 7};
        if (k <= 4) {
            return base[k - 1];
        }
        int[] dp = new int[k];
        dp[0] = 1;
        dp[1] = 3;
        dp[2] = 5;
        dp[3] = 7;
        int i3 = 1, i5 = 2, i7 = 3;
        for (int i = 4; i < k; i++) {
            int min = Math.min(dp[i3] * 3, Math.min(dp[i5] * 5, dp[i7] * 7));
            dp[i] = min;
            while (dp[i3] * 3 <= min) {
                i3++;
            }
            while (dp[i5] * 5 <= min) {
                i5++;
            }
            while (dp[i7] * 7 <= min) {
                i7++;
            }
        }
        return dp[k - 1];
    }
}
