package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    ����һ�� n �� m �е��������������� q ��������ÿ����������������� x1,y1,x2,y2,c������ (x1,y1) �� (x2,y2) ��ʾһ���Ӿ�������Ͻ���������½����ꡣ

    ÿ��������Ҫ��ѡ�е��Ӿ����е�ÿ��Ԫ�ص�ֵ���� c��

    ���㽫���������в�����ľ��������

    �����ʽ
    ��һ�а������� n,m,q��

    ������ n �У�ÿ�а��� m ����������ʾ��������

    ������ q �У�ÿ�а��� 5 ������ x1,y1,x2,y2,c����ʾһ��������

    �����ʽ
    �� n �У�ÿ�� m ����������ʾ���в���������Ϻ�����վ���

    ���ݷ�Χ
    1��n,m��1000,
    1��q��100000,
    1��x1��x2��n,
    1��y1��y2��m,
    ?1000��c��1000,
    ?1000�ܾ�����Ԫ�ص�ֵ��1000
    ����������
    3 4 3
    1 2 2 1
    3 2 2 1
    1 1 1 1
    1 1 2 2 1
    1 3 2 3 2
    3 1 3 4 1
    ���������
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
