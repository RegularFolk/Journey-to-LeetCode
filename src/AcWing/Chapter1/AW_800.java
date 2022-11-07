package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    ������������������������� A �� B���Լ�һ��Ŀ��ֵ x��

    �����±�� 0 ��ʼ��

    ����������� A[i]+B[j]=x ������ (i,j)��

    ���ݱ�֤��Ψһ�⡣

    �����ʽ
    ��һ�а����������� n,m,x���ֱ��ʾ A �ĳ��ȣ�B �ĳ����Լ�Ŀ��ֵ x��

    �ڶ��а��� n ����������ʾ���� A��

    �����а��� m ����������ʾ���� B��

    �����ʽ
    ��һ�У������������� i �� j��

    ���ݷ�Χ
    ���鳤�Ȳ����� 105��
    ͬһ������Ԫ�ظ�����ͬ��
    1������Ԫ�ء�109
    ����������
    4 5 6
    1 2 4 7
    3 4 6 8 9
    ���������
    1 1
* */
public class AW_800 {
    public static void main(String[] args) {
        int[] ints = AWUtils.intsInput();
        int n = ints[0], m = ints[1], x = ints[2];
        int[] a = AWUtils.intArrayInput(n);
        int[] b = AWUtils.intArrayInput(m);
        int[] ans = tarSum(a, b, x);
        AWUtils.printArrayInline(ans);
    }

    private static int[] tarSum(int[] a, int[] b, int x) {
        int l = 0, r = b.length - 1;
        while (l < a.length && r >= 0) {
            int curSum = a[l] + b[r];
            if (curSum == x) return new int[]{l, r};
            else if (curSum < x) l++;
            else r--;
        }
        return null;
    }
}
