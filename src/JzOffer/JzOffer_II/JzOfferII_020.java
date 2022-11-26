package JzOffer.JzOffer_II;

public class JzOfferII_020 {
    /*
     * 二维动态规划
     *   dp[i][j]表示从下标i到下标j是否为回文串
     * 同 Medium LC_647
     * */
    public int countSubstrings(String s) {
        int ans = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] sc = s.toCharArray();
        for (int start = 0; start < sc.length; start++) {
            int row = 0, col = start;
            while (row < sc.length && col < sc.length) {
                if (sc[row] == sc[col] && (col - row <= 2 || (dp[row + 1][col - 1]))) {
                    dp[row][col] = true;
                    ans++;
                }
                row++;
                col++;
            }
        }
        return ans;
    }

}
