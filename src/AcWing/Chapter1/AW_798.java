package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    输入一个 n 行 m 列的整数矩阵，再输入 q 个操作，每个操作包含五个整数 x1,y1,x2,y2,c，其中 (x1,y1) 和 (x2,y2) 表示一个子矩阵的左上角坐标和右下角坐标。

    每个操作都要将选中的子矩阵中的每个元素的值加上 c。

    请你将进行完所有操作后的矩阵输出。

    输入格式
    第一行包含整数 n,m,q。

    接下来 n 行，每行包含 m 个整数，表示整数矩阵。

    接下来 q 行，每行包含 5 个整数 x1,y1,x2,y2,c，表示一个操作。

    输出格式
    共 n 行，每行 m 个整数，表示所有操作进行完毕后的最终矩阵。

    数据范围
    1≤n,m≤1000,
    1≤q≤100000,
    1≤x1≤x2≤n,
    1≤y1≤y2≤m,
    ?1000≤c≤1000,
    ?1000≤矩阵内元素的值≤1000
    输入样例：
    3 4 3
    1 2 2 1
    3 2 2 1
    1 1 1 1
    1 1 2 2 1
    1 3 2 3 2
    3 1 3 4 1
    输出样例：
    2 3 4 1
    4 3 4 1
    2 2 2 2
* */
public class AW_798 {
    public static void main(String[] args) {
        int[] ints = AWUtils.intsInput();
        int n = ints[0], q = ints[2];
        int[][] matrix = AWUtils.intsArrayInput(n);
        int[][] ops = AWUtils.intsArrayInput(q);
        int[][] ans = diff(matrix, ops);
        AWUtils.printDoubleArray(ans);
    }

    private static int[][] diff(int[][] matrix, int[][] ops) {
        int[][] b = new int[matrix.length][matrix[0].length];
        for (int[] op : ops) {
            b[op[0] - 1][op[1] - 1] += op[4];
            if (op[2] < matrix.length && op[3] < matrix[0].length) b[op[2]][op[3]] += op[4];
            if (op[3] < matrix[0].length) b[op[0] - 1][op[3]] -= op[4];
            if (op[2] < matrix.length) b[op[2]][op[1] - 1] -= op[4];
        }
        for (int i = 1; i < b.length; i++) {
            b[i][0] += b[i - 1][0];
        }
        for (int i = 1; i < b[0].length; i++) {
            b[0][i] += b[0][i - 1];
        }
        for (int i = 1; i < b.length; i++) {
            for (int j = 1; j < b[i].length; j++) {
                b[i][j] += b[i - 1][j] + b[i][j - 1] - b[i - 1][j - 1];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] += b[i][j];
            }
        }
        return matrix;
    }
}
