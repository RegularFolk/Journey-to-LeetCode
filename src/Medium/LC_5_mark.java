package Medium;

public class LC_5_mark {
    /*
     * 动态规划  同类题LC_647
     * dp[i][j]表示下标 i~j的子串是否为回文子串
     * 当char[i]==char[j]&&dp[i+1][j-1]时，dp[i][j]=true
     * 还有一个关键，在于dp数组的遍历顺序，沿着左上到右下的对角线叠金字塔往右上角叠
     * 时间复杂度为O(n^2)，因为dp数组的状态有(n^2)/2个
     * */
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 1, l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int start = 0; start < s.length() - 1; start++) {
            for (int row = 0, col = start + 1; row < s.length() && col < s.length(); row++, col++) {
                if (validate(chars, dp, row, col)) {
                    dp[row][col] = true;
                    int dis = col - row + 1;
                    if (dis > max) {
                        max = dis;
                        l = row;
                        r = col;
                    }
                }
            }
        }
        return s.substring(l, r + 1);
    }

    private boolean validate(char[] chars, boolean[][] dp, int i, int j) {
        return chars[i] == chars[j] && (j - i <= 2 || dp[i + 1][j - 1]);
    }
}
