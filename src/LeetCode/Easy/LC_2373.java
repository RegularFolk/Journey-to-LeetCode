package LeetCode.Easy;

public class LC_2373 {
    public int[][] largestLocal(int[][] grid) {
        int[][] ans = new int[grid.length - 2][grid.length - 2];
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid.length - 2; j++) {
                ans[i][j] = getMax(grid, i, j);
            }
        }
        return ans;
    }

    private int getMax(int[][] grid, int i, int j) {
        int ans = -1;
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                ans = Math.max(ans, grid[k][l]);
            }
        }
        return ans;
    }
}
