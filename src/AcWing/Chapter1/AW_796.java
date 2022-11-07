package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    输入一个 n 行 m 列的整数矩阵，再输入 q 个询问，每个询问包含四个整数 x1,y1,x2,y2，表示一个子矩阵的左上角坐标和右下角坐标。

    对于每个询问输出子矩阵中所有数的和。

    输入格式
    第一行包含三个整数 n，m，q。

    接下来 n 行，每行包含 m 个整数，表示整数矩阵。

    接下来 q 行，每行包含四个整数 x1,y1,x2,y2，表示一组询问。

    输出格式
    共 q 行，每行输出一个询问的结果。

    数据范围
    1≤n,m≤1000,
    1≤q≤200000,
    1≤x1≤x2≤n,
    1≤y1≤y2≤m,
    ?1000≤矩阵内元素的值≤1000
    输入样例：
    3 4 3
    1 7 2 4
    3 6 2 8
    2 1 2 3
    1 1 2 2
    2 1 3 4
    1 3 3 4
    输出样例：
    17
    27
    21
* */
public class AW_796 {
    public static void main(String[] args) {
        int[] ints = AWUtils.intsInput();
        int n = ints[0], q = ints[2];
        int[][] matrix = AWUtils.intsArrayInput(n);
        int[][] queries = AWUtils.intsArrayInput(q);
        int[] ans = subMatrixSum(matrix, queries);
        AWUtils.printArrayByLine(ans);
    }

    //x是一维坐标，y是二维坐标
    private static int[] subMatrixSum(int[][] matrix, int[][] queries) {
        int[][] preSum = getPreSumMatrix(matrix);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = preSum[queries[i][2] - 1][queries[i][3] - 1] -
                    (queries[i][0] - 2 < 0 ? 0 : preSum[queries[i][0] - 2][queries[i][3] - 1]) -
                    (queries[i][1] - 2 < 0 ? 0 : preSum[queries[i][2] - 1][queries[i][1] - 2]) +
                    (queries[i][0] - 2 == -1 || queries[i][1] - 2 == -1 ? 0 : preSum[queries[i][0] - 2][queries[i][1] - 2]);
        }
        return ans;
    }

    private static int[][] getPreSumMatrix(int[][] matrix) {
        for (int i = 1; i < matrix[0].length; i++) {
            matrix[0][i] += matrix[0][i - 1];
        }
        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] += matrix[i - 1][0];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                matrix[i][j] += matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1];
            }
        }
        return matrix;
    }
}
