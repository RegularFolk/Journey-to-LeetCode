package Medium;

public class LC_240 {
    /*
     * 同Interview_10_09
     * */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (true) {
            row = searchCol(matrix, target, row, col);
            if (row == -1) {
                return false;
            } else if (matrix[row][col] == target) {
                return true;
            }
            col = searchRow(matrix, target, row, col);
            if (col == -1) {
                return false;
            } else if (matrix[row][col] == target) {
                return true;
            }
        }
    }

    private int searchRow(int[][] matrix, int target, int row, int col) {
        int l = 0, r = col, pos = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (matrix[row][mid] <= target) {
                l = mid + 1;
                pos = mid;
            } else {
                r = mid - 1;
            }
        }
        return pos;
    }

    private int searchCol(int[][] matrix, int target, int row, int col) {
        int l = row, r = matrix.length - 1, pos = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (matrix[mid][col] >= target) {
                r = mid - 1;
                pos = mid;
            } else {
                l = mid + 1;
            }
        }
        return pos;
    }
}
