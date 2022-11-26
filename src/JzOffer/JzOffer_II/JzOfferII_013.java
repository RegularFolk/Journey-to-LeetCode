package JzOffer.JzOffer_II;

public class JzOfferII_013 {
    /*
     * 二维前缀和 模板题
     * */
    static class NumMatrix {
        int[][] matrix;
        int[][] pre;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            getPre(matrix);
        }

        private void getPre(int[][] matrix) {
            int[][] pre = new int[matrix.length][matrix[0].length];
            pre[0][0] = matrix[0][0];
            for (int col = 1; col < matrix[0].length; col++) {
                pre[0][col] = pre[0][col - 1] + matrix[0][col];
            }
            for (int row = 1; row < matrix.length; row++) {
                pre[row][0] = pre[row - 1][0] + matrix[row][0];
            }
            for (int row = 1; row < matrix.length; row++) {
                for (int col = 1; col < matrix[row].length; col++) {
                    pre[row][col] = pre[row - 1][col] + pre[row][col - 1] - pre[row - 1][col - 1] + matrix[row][col];
                }
            }
            this.pre = pre;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (col1 > 0 && row1 > 0)
                return pre[row2][col2] - pre[row2][col1 - 1] - pre[row1 - 1][col2] + pre[row1 - 1][col1 - 1];
            else if (col1 > 0) return pre[row2][col2] - pre[row2][col1 - 1];
            else if (row1 > 0) return pre[row2][col2] - pre[row1 - 1][col2];
            else return pre[row2][col2];
        }
    }
}
