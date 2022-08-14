package JzOffer;

import org.junit.Test;

public class JzOffer_47 {
    @Test
    public void te() {
        System.out.println("maxValue() = " + maxValue1(new int[][]{
                {3, 8, 6, 0, 5, 9, 9, 6, 3, 4, 0, 5, 7, 3, 9, 3},
                {0, 9, 2, 5, 5, 4, 9, 1, 4, 6, 9, 5, 6, 7, 3, 2},
                {8, 2, 2, 3, 3, 3, 1, 6, 9, 1, 1, 6, 6, 2, 1, 9},
                {1, 3, 6, 9, 9, 5, 0, 3, 4, 9, 1, 0, 9, 6, 2, 7},
                {8, 6, 2, 2, 1, 3, 0, 0, 7, 2, 7, 5, 4, 8, 4, 8},
                {4, 1, 9, 5, 8, 9, 9, 2, 0, 2, 5, 1, 8, 7, 0, 9},
                {6, 2, 1, 7, 8, 1, 8, 5, 5, 7, 0, 2, 5, 7, 2, 1},
                {8, 1, 7, 6, 2, 8, 1, 2, 2, 6, 4, 0, 5, 4, 1, 3},
                {9, 2, 1, 7, 6, 1, 4, 3, 8, 6, 5, 5, 3, 9, 7, 3},
                {0, 6, 0, 2, 4, 3, 7, 6, 1, 3, 8, 6, 9, 0, 0, 8},
                {4, 3, 7, 2, 4, 3, 6, 4, 0, 3, 9, 5, 3, 6, 9, 3},
                {2, 1, 8, 8, 4, 5, 6, 5, 8, 7, 3, 7, 7, 5, 8, 3},
                {0, 7, 6, 6, 1, 2, 0, 3, 5, 0, 8, 0, 8, 7, 4, 3},
                {0, 4, 3, 4, 9, 0, 1, 9, 7, 7, 8, 6, 4, 6, 9, 5},
                {6, 5, 1, 9, 9, 2, 2, 7, 4, 2, 7, 2, 2, 3, 7, 2},
                {7, 1, 9, 6, 1, 2, 7, 0, 9, 6, 6, 4, 4, 5, 1, 0},
                {3, 4, 9, 2, 8, 3, 1, 2, 6, 9, 7, 0, 2, 4, 2, 0},
                {5, 1, 8, 8, 4, 6, 8, 5, 2, 4, 1, 6, 2, 2, 9, 7}}));
    }

    public int maxValue1(int[][] grid) {  //无脑回溯，会超时
        return route(grid, 0, 0, 0);
    }

    private int route(int[][] grid, int x, int y, int current) {
        int xl = grid[0].length - 1, yl = grid.length - 1;
        if (x == xl && y == yl) {
            return current + grid[yl][xl];
        } else {
            current += grid[y][x];
            if (x != xl && y != yl) {
                return Math.max(route(grid, x + 1, y, current), route(grid, x, y + 1, current));
            } else if (x == xl) {
                return route(grid, x, y + 1, current);
            } else {
                return route(grid, x + 1, y, current);
            }
        }
    }

    public int maxValue2(int[][] grid) { //最基础的动态规划
        int x = grid[0].length, y = grid.length;
        for (int row = 0; row < y; row++) {
            for (int col = 0; col < x; col++) {
                int left = 0, up = 0;
                if (col > 0) {
                    left = grid[row][col - 1];
                }
                if (row > 0) {
                    up = grid[row - 1][col];
                }
                grid[row][col] += Math.max(left, up);
            }
        }
        return grid[y - 1][x - 1];
    }
}
