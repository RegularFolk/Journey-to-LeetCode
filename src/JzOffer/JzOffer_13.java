package JzOffer;

import org.junit.Test;

public class JzOffer_13 {

    @Test
    public void test(){
        System.out.println(movingCount(2,3,1));
    }

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return count(m, n, k, 0, 0, visited);
    }

    private int count(int rows, int cols, int k, int row, int col, boolean[][] visited) {
        int count = 0;
        if (check(rows, cols, k, row, col, visited)) {//检查当前这格可以走
            visited[row][col] = true;
            count = 1 + count(rows, cols, k, row + 1, col, visited)
                    + count(rows, cols, k, row - 1, col, visited)
                    + count(rows, cols, k, row, col + 1, visited)
                    + count(rows, cols, k, row, col - 1, visited);
        }
        return count;
    }

    private boolean check(int rows, int cols, int k, int row, int col, boolean[][] visited) {
        return row >= 0 && col >= 0 && col < cols && row < rows && !visited[row][col] && getDigitSum(row) + getDigitSum(col) <= k;
    }

    private int getDigitSum(int col) {
        int ans = 0;
        while (col > 0) {
            ans += col % 10;
            col /= 10;
        }
        return ans;
    }
}
