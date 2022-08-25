package CrackCodeInterview.I_Array_String;

import java.util.Arrays;

public class Interview_01_08 {
    public void setZeroes(int[][] matrix) {
        if (matrix != null) {
            boolean row = false, column = false;
            for (int[] ints : matrix) {
                if (ints[0] == 0) {
                    column = true;
                    break;
                }
            }
            for (int i : matrix[0]) {
                if (i == 0) {
                    row = true;
                    break;
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    Arrays.fill(matrix[i], 0);
                }
            }
            for (int i = 1; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    for (int j = 1; j < matrix.length; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
            if (column) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
            if (row) {
                Arrays.fill(matrix[0], 0);
            }
        }
    }
}
