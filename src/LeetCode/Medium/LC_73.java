package LeetCode.Medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LC_73 {
    public static void main(String[] args) {

    }

    public static void setZeroes(int[][] matrix) {
        //idea推荐的高级写法...
        boolean x = IntStream.range(0, matrix[0].length).anyMatch(i -> matrix[0][i] == 0);
        boolean y = IntStream.range(0, matrix.length).anyMatch(i -> matrix[i][0] == 0);
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (x) {
            Arrays.fill(matrix[0], 0);
        }
        if (y) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
