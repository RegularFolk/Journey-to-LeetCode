package JzOffer.JzOffer_II;

public class JzOfferII_105 {
    /*
     * ²¡¶¾ÂûÑÓ Ä£Äâ
     * */
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    int size = count(grid, row, col);
                    ans = Math.max(ans, size);
                }
            }
        }
        return ans;
    }

    private int count(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0) return 0;
        grid[row][col] = 0;
        return 1 + count(grid, row + 1, col) +
                count(grid, row - 1, col) +
                count(grid, row, col + 1) +
                count(grid, row, col - 1);
    }
}
