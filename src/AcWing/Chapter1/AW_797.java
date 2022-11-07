package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    ����һ������Ϊ n ���������С�

    ���������� m ��������ÿ������������������ l,r,c����ʾ�������� [l,r] ֮���ÿ�������� c��

    ����������������в���������С�

    �����ʽ
    ��һ�а����������� n �� m��

    �ڶ��а��� n ����������ʾ�������С�

    ������ m �У�ÿ�а����������� l��r��c����ʾһ��������

    �����ʽ
    ��һ�У����� n ����������ʾ�������С�

    ���ݷ�Χ
    1��n,m��100000,
    1��l��r��n,
    ?1000��c��1000,
    ?1000������������Ԫ�ص�ֵ��1000
    ����������
    6 3
    1 2 2 1 2 1
    1 3 1
    3 5 1
    1 6 1
    ���������
    3 4 5 3 4 2
* */
public class AW_797 {
    public static void main(String[] args) {
        int[] ints = AWUtils.intsInput();
        int n = ints[0], m = ints[1];
        int[] arr = AWUtils.intArrayInput(n);
        int[][] ops = AWUtils.intsArrayInput(m);
        int[] ans = diff(arr, ops);
        AWUtils.printArrayInline(ans);
    }

    private static int[] diff(int[] arr, int[][] ops) {
        int[] b = new int[arr.length];
        for (int[] op : ops) {
            b[op[0] - 1] += op[2];
            if (op[1] < b.length) b[op[1]] -= op[2];
        }
        arr[0] += b[0];
        for (int i = 1; i < arr.length; i++) {
            b[i] += b[i - 1];
            arr[i] += b[i];
        }
        return arr;
    }
}
