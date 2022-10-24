package Leet.Medium;

import java.util.Arrays;

public class LC_6081 {
    /*
     * ¶¯Ì¬¹æ»®
     * */
    public int longestContinuousSubstring(String s) {
        int ans = 1;
        int[] dp = new int[s.length()];
        char[] chars = s.toCharArray();
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            if (chars[i - 1] + 1 == chars[i]) {
                dp[i] = dp[i - 1] + 1;
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
