package Leet.Easy;

public class LC_1582 {
    /*
    * 数据量小，模拟即可
    * */
    public int numSpecial(int[][] mat) {
        int ans = 0;
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[r].length; c++) {
                if (mat[r][c] == 1) {
                    boolean flag = false;
                    for (int i = c + 1; i < mat[r].length; i++) {
                        if (mat[r][i] == 1) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) break;
                    for (int i = 0; i < mat.length; i++) {
                        if (mat[i][c] == 1 && i != r) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) ans++;
                }
            }
        }
        return ans;
    }
}
