package LeetCode.Medium;

public class LC_64 {
    /*
     * 原地动态规划
     * dp[i][j]表示从点(i,j)到终点的最小路径
     * dp[i][j] += min(dp[i+1][j],dp[i][j+1])
     * */
    public int minPathSum(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                boolean right = j < grid[0].length - 1, down = i < grid.length - 1;
                grid[i][j] += right && down ? Math.min(grid[i + 1][j], grid[i][j + 1]) : right ? grid[i][j + 1] : down ? grid[i + 1][j] : 0;
            }
        }
        return grid[0][0];
    }
}
