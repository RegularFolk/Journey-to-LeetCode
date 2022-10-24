package Leet.Hard;

import java.util.HashSet;
import java.util.Set;

public class LC_827 {
    /*
     * 直接dfs会超时
     * 优化，在首次遍历时把每个岛屿大小记录下来，转换时可以快速获取转换后的大小
     * 致命缺陷，如何判断设置一个点为1后该点四周的岛屿是不同的岛屿？如果同一个岛屿围在四周则面积重复相加
     * 优化，给每个岛屿再加上一个标识 通过
     * 时间复杂度n^2
     * */
    private int count = 1;

    public int largestIsland(int[][] grid) {
        int[][] mark = new int[grid.length][grid.length];
        int ans = getMax(grid, mark);
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 0) {
                    int newSize = 1 + getNeighbour(grid, row, col, mark);
                    ans = Math.max(ans, newSize);
                }
            }
        }
        return ans;
    }

    private int getNeighbour(int[][] grid, int row, int col, int[][] mark) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        if (row > 0) {
            ans += grid[row - 1][col];
            set.add(mark[row - 1][col]);
        }
        if (row < grid.length - 1 && !set.contains(mark[row + 1][col])) {
            ans += grid[row + 1][col];
            set.add(mark[row + 1][col]);
        }
        if (col > 0 && !set.contains(mark[row][col - 1])) {
            ans += grid[row][col - 1];
            set.add(mark[row][col - 1]);
        }
        if (col < grid.length - 1 && !set.contains(mark[row][col + 1])) {
            ans += grid[row][col + 1];
            set.add(mark[row][col + 1]);
        }
        return ans;
    }

    /*
     * 获取max的同时将整片区域标记上面积
     * */
    private int getMax(int[][] grid, int[][] mark) {
        int max = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    int size = getSize(grid, row, col, new boolean[grid.length][grid.length]);
                    max = Math.max(max, size);
                    spread(grid, row, col, size, mark);
                    count++;
                }
            }
        }
        return max;
    }

    private void spread(int[][] grid, int row, int col, int size, int[][] mark) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] == 1) {
            grid[row][col] = size;
            mark[row][col] = count;
            spread(grid, row + 1, col, size, mark);
            spread(grid, row - 1, col, size, mark);
            spread(grid, row, col + 1, size, mark);
            spread(grid, row, col - 1, size, mark);
        }
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
