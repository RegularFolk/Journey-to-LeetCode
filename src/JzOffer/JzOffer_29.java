package JzOffer;

/*
打印矩阵  未完成
*/
public class JzOffer_29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        } //通过start、endX和endY三个变量划定边界
        int start = 0, column = matrix[0].length, row = matrix.length, cursor = 0;
        int[] ans = new int[column * row];
        while (column > start * 2 && row > start * 2) {
            int endX = column - start - 1, endY = row - 1 - start;
            for (int i = start; i <= endX; i++) {//l to r
                ans[cursor++] = matrix[start][i];
            }
            if (start < endY) {
                for (int i = start + 1; i <= endY; i++) { //up to down
                    ans[cursor++] = matrix[i][endX];
                }
            }
            if (start < endX && start <= endY) {
                for (int i = endX - 1; i >= start; i--) { //r to l
                    ans[cursor++] = matrix[endY][i];
                }
            }
            if (start < endX && start < endY - 1) {
                for (int i = endY - 1; i >= start + 1; i--) {//down to up
                    ans[cursor++] = matrix[i][start];
                }
            }
            start++;
        }
        return ans;
    }
}


