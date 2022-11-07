package LeetCode.Medium;

import org.junit.Test;

public class LC_221 {
    /*
     * 原地dp
     * dp[row][col]表示以点(row,col)为右下角可以组成的最大正方形边长
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
     * 优化
     * 如果dp[row][col]是某个正方形的右下角，则左边、上边和左上边也都是某个正方形的右下角(否则就是1)
     * 该点边长为比较的三个点边长的最小值+1
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