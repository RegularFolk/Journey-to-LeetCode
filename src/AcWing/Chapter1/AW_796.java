package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    ����һ�� n �� m �е��������������� q ��ѯ�ʣ�ÿ��ѯ�ʰ����ĸ����� x1,y1,x2,y2����ʾһ���Ӿ�������Ͻ���������½����ꡣ

    ����ÿ��ѯ������Ӿ������������ĺ͡�

    �����ʽ
    ��һ�а����������� n��m��q��

    ������ n �У�ÿ�а��� m ����������ʾ��������

    ������ q �У�ÿ�а����ĸ����� x1,y1,x2,y2����ʾһ��ѯ�ʡ�

    �����ʽ
    �� q �У�ÿ�����һ��ѯ�ʵĽ����

    ���ݷ�Χ
    1��n,m��1000,
    1��q��200000,
    1��x1��x2��n,
    1��y1��y2��m,
    ?1000�ܾ�����Ԫ�ص�ֵ��1000
    ����������
    3 4 3
    1 7 2 4
    3 6 2 8
    2 1 2 3
    1 1 2 2
    2 1 3 4
    1 3 3 4
    ���������
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

    //x��һά���꣬y�Ƕ�ά����
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
