package LeetCode.Medium;

public class LC_74 {
    /*
     * 二位矩阵搜索
     * 先水平搜索，然后垂直搜索（反过来也可以）
     * 横着搜，找到第一个小于tar的，再竖着搜，找到第一个大于tar的
     * */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            while (col >= 0 && matrix[row][col] >= target) {
                if (matrix[row][col] == target) return true;
                col--;
            }
            if (col >= 0) {
                while (row < matrix.length && matrix[row][col] <= target) {
                    if (matrix[row][col] == target) return true;
                    row++;
                }
            }
        }
        return false;
    }
}
