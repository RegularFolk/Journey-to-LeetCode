package Hard;

import org.junit.Test;

public class LC_329 {
    /*
     * 矩形DP+DFS
     * dp[i][j][k]表示从(i,j)开始往方向k可以走的最大值
     * dp数组用来剪枝
     * 0左 1右 2上 3下
     * 别被四个方向搞乱了
     * */
    private int max = 1;

    public int longestIncreasingPath(int[][] matrix) {
        int[][][] dp = new int[matrix.length][matrix[0].length][4];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                find(dp, matrix, row, col, (long) Integer.MIN_VALUE - 1);
            }
        }
        return max;
    }

    /**
     * @param dp     dp数组
     * @param matrix 矩阵
     * @param row    行数
     * @param col    列数
     * @param prev   之前对应的矩阵值
     * @return 从该点往四个方向走的最大长度
     */
    private int find(int[][][] dp, int[][] matrix, int row, int col, long prev) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] <= prev) {
            return 0;
        }
        if (dp[row][col][0] == 0) dp[row][col][0] = find(dp, matrix, row, col - 1, matrix[row][col]);
        if (dp[row][col][1] == 0) dp[row][col][1] = find(dp, matrix, row, col + 1, matrix[row][col]);
        if (dp[row][col][2] == 0) dp[row][col][2] = find(dp, matrix, row - 1, col, matrix[row][col]);
        if (dp[row][col][3] == 0) dp[row][col][3] = find(dp, matrix, row + 1, col, matrix[row][col]);
        int curMax = Math.max(Math.max(Math.max(dp[row][col][0], dp[row][col][1]), dp[row][col][2]), dp[row][col][3]) + 1;
        max = Math.max(max, curMax);
        return curMax;
    }

    @Test
    public void x() {
        int i = longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}});
        System.out.println(i);
    }
}
