package Leet.Medium;

public class LC_200 {
    /*
     * ��Ⱦ���ҵ�һ��1������ڵ�ȫ�����0
     * */
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    ans++;
                    transform(grid, row, col);
                }
            }
        }
        return ans;
    }

    private void transform(char[][] grid, int row, int col) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] == '1') {
            grid[row][col]--;
            transform(grid, row + 1, col);
            transform(grid, row, col + 1);
            transform(grid, row - 1, col);
            transform(grid, row, col - 1);
        }
    }
}
