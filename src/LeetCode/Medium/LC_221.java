package LeetCode.Medium;

import org.junit.Test;

public class LC_221 {
    /*
     * ԭ��dp
     * dp[row][col]��ʾ�Ե�(row,col)Ϊ���½ǿ�����ɵ���������α߳�
     * */
    public int maximalSquare1(char[][] matrix) {
        int max = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] >= '1') {
                    max = Math.max(max, check(matrix, row, col));
                }
            }
        }
        return max * max;
    }

    private int check(char[][] matrix, int row, int col) {
        if (row == 0 || col == 0 || matrix[row - 1][col - 1] == '0') {
            return 1;
        } else {
            for (int i = 1; i <= matrix[row - 1][col - 1] - '0'; i++) {
                if (matrix[row - i][col] == '0' || matrix[row][col - i] == '0') {
                    matrix[row][col] = (char) ('0' + i);
                    return i;
                }
            }
            matrix[row][col] = (char) (matrix[row - 1][col - 1] + 1);
            return matrix[row][col] - '0';
        }
    }

    /*
     * �Ż�
     * ���dp[row][col]��ĳ�������ε����½ǣ�����ߡ��ϱߺ����ϱ�Ҳ����ĳ�������ε����½�(�������1)
     * �õ�߳�Ϊ�Ƚϵ�������߳�����Сֵ+1
     * */
    public int maximalSquare2(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int row = 0; row < dp.length; row++) {
            for (int col = 0; col < dp[row].length; col++) {
                if (matrix[row][col] == '1') {
                    dp[row][col] = check1(dp, row, col);
                    max = Math.max(max, dp[row][col]);
                }
            }
        }
        return max * max;
    }

    private int check1(int[][] dp, int row, int col) {
        if (row == 0 || col == 0) {
            return 1;
        }
        return Math.min(dp[row - 1][col - 1], Math.min(dp[row - 1][col], dp[row][col - 1])) + 1;
    }

    @Test
    public void s() {
        int i = maximalSquare1(new char[][]{
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}});
        System.out.println(i);
    }
}