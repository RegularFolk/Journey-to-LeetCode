package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    ������һ������Ϊ n ���������С�

    ����ʹ�ÿ��������������а��մ�С�����������

    �����ź�������а�˳�������

    �����ʽ
    ���빲���У���һ�а������� n��

    �ڶ��а��� n �������������������� 1?109 ��Χ�ڣ�����ʾ�������С�

    �����ʽ
    �����һ�У����� n ����������ʾ�ź�������С�

    ���ݷ�Χ
    1��n��100000
    ����������
    5
    3 1 2 4 5
    ���������
    1 2 3 4 5
* */
public class AW_785 {
    public static void main(String[] args) {
        int n = AWUtils.intInput();
        long[] arrays = AWUtils.longArrayInput(n);
        qSort(arrays, 0, arrays.length - 1);
        AWUtils.printArrayInline(arrays);
    }

    //��������
    private static void qSort(long[] arrays, int left, int right) {
        if (left < right) {
            long pivot = arrays[left];
            int l = left - 1, r = right + 1;//�Ⱥ���һ����Ϊ������do
            while (l < r) {
                do l++; while (arrays[l] < pivot);
                do r--; while (arrays[r] > pivot);
                if (l < r) AWUtils.swapArray(arrays, l, r);
            }
            qSort(arrays, left, r);
            qSort(arrays, r + 1, right);
        }
    }
}
