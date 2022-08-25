package Medium;

public class LC_647 {
    /*
     * 动态规划
     * LC_5的简化版
     * */
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = s.length();
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int start = 1; start < s.length(); start++) {
            for (int row = 0, col = start; row < s.length() && col < s.length(); row++, col++) {
                if (chars[row] == chars[col] && (col - row <= 2 || dp[row + 1][col - 1])) {
                    count++;
                    dp[row][col] = true;
                }
            }
        }
        return count;
    }
}
