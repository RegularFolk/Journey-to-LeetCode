package Medium;

import java.util.Arrays;

public class LC_48____ {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5,}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotate(int[][] matrix) {
        int temp1;
        int temp2;
        int temp3;
        int temp4;
        int n = matrix[0].length - 1;
        int time = n / 2;
        if (n >= 1) {
            for (int i = n; i >= 1 && time >= 0; i -= 2) {  //选定一周，从最外围开始,i为当前边长
                for (int j = n / 2 - time; j < i; j++) {
                    temp1 = matrix[n / 2 - time][j];
                    temp2 = matrix[j][n - (n / 2 - time)];
                    temp3 = matrix[n - (n / 2 - time)][n - j];
                    temp4 = matrix[i - j][n - (n / 2 - time)];
                    matrix[n / 2 - time][j] = temp4;
                    matrix[j][n - (n / 2 - time)] = temp1;
                    matrix[n - (n / 2 - time)][n - j] = temp2;
                    matrix[i - j][n - (n / 2 - time)] = temp3;
                }
                time--;
            }
        }
    }
}
