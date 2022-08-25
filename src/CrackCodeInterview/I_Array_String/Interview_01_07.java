package CrackCodeInterview.I_Array_String;

import org.junit.Test;

public class Interview_01_07 {
    @Test
    public void t() {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "/");
            }
            System.out.println('/');
        }
    }

    public void rotate(int[][] matrix) {
        if (matrix != null && matrix.length > 1) {
            int start = 0, mid = matrix.length >> 1;
            while (start < mid) { //外圈
                int end = matrix.length - start - 1, dis = end - start;
                for (int i = 0; i < dis; i++) {
                    int temp1 = matrix[start][start + i];
                    matrix[start][start + i] = matrix[end - i][start];//temp1 = temp4
                    matrix[end - i][start] = matrix[end][end - i]; //temp4 = temp3
                    matrix[end][end - i] = matrix[start + i][end];//temp3 = temp2
                    matrix[start + i][end] = temp1;  //temp2 = temp1
                }
                start++;
            }
        }
    }
}
