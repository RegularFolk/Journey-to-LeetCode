package Medium;

public class LC_5_mark {
    /*
     * ��̬�滮  ͬ����LC_647
     * dp[i][j]��ʾ�±� i~j���Ӵ��Ƿ�Ϊ�����Ӵ�
     * ��char[i]==char[j]&&dp[i+1][j-1]ʱ��dp[i][j]=true
     * ����һ���ؼ�������dp����ı���˳���������ϵ����µĶԽ��ߵ������������Ͻǵ�
     * ʱ�临�Ӷ�ΪO(n^2)����Ϊdp�����״̬��(n^2)/2��
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
