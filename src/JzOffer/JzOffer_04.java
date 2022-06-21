package JzOffer;

public class JzOffer_04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) { //着眼于角上的点，从右上角或者左下角开始
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int x = matrix[0].length - 1, y = 0, length = matrix.length;
        while (x >= 0 && y < length) {
            if (matrix[y][x] > target) {
                x--;
            } else if (matrix[y][x] < target) {
                y++;
            } else {
                return true;
            }
        }
        return false;
    }
}
