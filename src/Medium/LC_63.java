package Medium;

public class LC_63 {
    /*
     * 同LC_62 dfs不可能比动态规划更优
     * */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1] = 1;
        for (int i = obstacleGrid.length - 1; i >= 0; i--) {
            for (int j = obstacleGrid[0].length - 1; j >= 0; j--) {
                dp[i][j] += obstacleGrid[i][j] == 1 ? 0 : dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}
