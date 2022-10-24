package Leet.Hard;

import java.util.HashSet;
import java.util.Set;

public class LC_827 {
    /*
     * ֱ��dfs�ᳬʱ
     * �Ż������״α���ʱ��ÿ�������С��¼������ת��ʱ���Կ��ٻ�ȡת����Ĵ�С
     * ����ȱ�ݣ�����ж�����һ����Ϊ1��õ����ܵĵ����ǲ�ͬ�ĵ��죿���ͬһ������Χ������������ظ����
     * �Ż�����ÿ�������ټ���һ����ʶ ͨ��
     * ʱ�临�Ӷ�n^2
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
     * ��ȡmax��ͬʱ����Ƭ�����������
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
