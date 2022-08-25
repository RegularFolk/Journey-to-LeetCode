package CrackCodeInterview.X_Sorting_Searching;

import org.junit.Test;

public class Interview_10_09 {
    /*
    * 同Medium LC_240
    * 从右上角开始搜索，竖着横着不断使用二分，col=M,row=N时间复杂度为logM*logN
    * 实际提交却不如从右上开始线性搜索时间复杂度为MN来得快
    * */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int col = matrix[0].length - 1, row = 0;
        while (true) {//行列不再更新时结束
            row = binCol(matrix, target, col, row);
            if (row == -1) {
                return false;
            }
            if (matrix[row][col] == target) {
                return true;
            }
            col = binRow(matrix, target, col, row);
            if (col == -1) {
                return false;
            }
            if (matrix[row][col] == target) {
                return true;
            }
        }
    }

    /*
     * 在一行中寻找小于等于tar的最大值
     * */
    private int binRow(int[][] matrix, int target, int col, int row) {
        int pos = -1, lc = 0, rc = col;
        while (lc <= rc) {
            int mid = (lc + rc) >> 1;
            if (matrix[row][mid] <= target) {
                pos = mid;
                lc = mid + 1;
            } else {
                rc = mid - 1;
            }
        }
        return pos;
    }

    /*
     * 在一列中寻找大于等于tar的最小值
     * */
    private int binCol(int[][] matrix, int target, int col, int row) {
        int pos = -1, lc = row, rc = matrix.length - 1;
        while (lc <= rc) {
            int mid = (lc + rc) >> 1;
            if (matrix[mid][col] >= target) {
                pos = mid;
                rc = mid - 1;
            } else {
                lc = mid + 1;
            }
        }
        return pos;
    }

    @Test
    public void s() {
        boolean b = searchMatrix(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}}, 5);
        System.out.println(b);
    }
}
