package Hard;

import java.util.Arrays;

public class LC_827 {
    /*
    * 直接dfs会超时
    * 优化，在首次遍历时把每个岛屿大小记录下来，转换时可以快速获取转换后的大小
    * */
    public int largestIsland(int[][] grid) {
        int[][] copy = new int[grid.length][grid.length];
        for (int row = 0; row < grid.length; row++) {
            System.arraycopy(grid[row], 0, copy[row], 0, grid[row].length);
        }
        int ans = getMax(copy);
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 0) {
                    grid[row][col] = 1;
                    int size = getSize(grid, row, col, new boolean[grid.length][grid.length]);
                    ans = Math.max(ans, size);
                    grid[row][col] = 0;
                }
            }
        }
        return ans;
    }

    private int getMax(int[][] copy) {
        int max = 0;
        for (int row = 0; row < copy.length; row++) {
            for (int col = 0; col < copy[row].length; col++) {
                if (copy[row][col] == 1) {
                    int size = getSize(copy, row, col);
                    max = Math.max(max, size);
                }
            }
        }
        return max;
    }

    private int getSize(int[][] copy, int row, int col) {
        if (row < 0 || row >= copy.length || col < 0 || col >= copy[row].length || copy[row][col] == 0) {
            return 0;
        }
        copy[row][col] = 0;
        return 1 + getSize(copy, row + 1, col) +
                getSize(copy, row - 1, col) +
                getSize(copy, row, col + 1) +
                getSize(copy, row, col - 1);
    }

    private int getSize(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }
        visited[row][col] = true;
        return 1 + getSize(grid, row + 1, col, visited) +
                getSize(grid, row - 1, col, visited) +
                getSize(grid, row, col + 1, visited) +
                getSize(grid, row, col - 1, visited);
    }
}
