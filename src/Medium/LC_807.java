package Medium;

public class LC_807 {
    public static void main(String[] args) {
        System.out.println(maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}}));
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int ans = 0;
        int[][] record = new int[2][grid.length];
        for (int i = 0; i < grid.length; i++) {  //找出每一行的最大值
            int max = -1;
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, grid[i][j]);
            }
            record[0][i] = max;
        }
        for (int i = 0; i < grid[0].length; i++) { //找出每一列的最大值
            int max = -1;
            for (int[] ints : grid) {
                max = Math.max(max, ints[i]);
            }
            record[1][i] = max;
        }
        for (int i = 0; i < grid.length; i++) {
            int rowMin = record[0][i];
            for (int j = 0; j < grid[0].length; j++) {
                int min = Math.min(rowMin, record[1][j]);
                if (grid[i][j] < min) {
                    ans += min - grid[i][j];
                }
            }
        }
        return ans;
    }
}
