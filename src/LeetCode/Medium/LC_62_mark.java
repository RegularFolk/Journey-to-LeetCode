package LeetCode.Medium;

public class LC_62_mark {

    int ans = 0;

    /*
     * 暴力dfs，无情超时
     * */
    public int uniquePath1(int m, int n) {
        dfs(m, n, 1, 1);
        return ans;
    }

    private void dfs(int m, int n, int row, int col) {
        if (row <= m && col <= n) {
            if (row == m && col == n) {
                ans++;
            } else {
                dfs(m, n, row + 1, col);
                dfs(m, n, row, col + 1);
            }
        }
    }

    /*
     * 使用visited数组，记录改点共有几条路径，避免重复计算
     * 似乎还是很慢？
     * dfs铁超时
     * 回溯的力量是有极限的，最多到100
     * */
    public int uniquePaths2(int m, int n) {
        dfs(m, n, 1, 1, new int[m + 1][n + 1]);
        return ans;
    }

    private int dfs(int m, int n, int row, int col, int[][] visited) {
        if (row <= m && col <= n) {
            if (visited[row][col] != 0) {
                ans += visited[row][col];
                return visited[row][col];
            } else if (row == m && col == n) {
                ans++;
            } else {
                if (row + 1 <= m) {
                    visited[row][col] += dfs(m, n, row + 1, col, visited);
                }
                if (col + 1 <= n) {
                    visited[row][col] += dfs(m, n, row, col + 1, visited);
                }
            }
        }
        return 0;
    }

    /*
     * 从后往前，使用动态规划
     * dp[i][j] 代表从(i,j)移动到终点的路径数
     * dp[i][j]=dp[i+1][j]+dp[i][j+1]
     * 时间复杂度O(mn)
     * */
    public int uniquePaths3(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] += dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}
