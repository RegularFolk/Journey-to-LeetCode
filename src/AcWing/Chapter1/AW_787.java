package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    ������һ������Ϊ n ���������С�

    ����ʹ�ù鲢�����������а��մ�С�����������

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

public class AW_787 {
    public static void main(String[] args) {
        int n = AWUtils.intInput();
        long[] arr = AWUtils.longArrayInput(n);
        mergeSort(arr, new long[n], 0, n - 1);
        AWUtils.printArrayInline(arr);
    }

    private static void mergeSort(long[] arr, long[] temp, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) >> 1;
        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);
        int cur1 = left, cur2 = mid + 1, cur = left;
        while (cur1 <= mid && cur2 <= right) {
            if (arr[cur1] <= arr[cur2]) temp[cur++] = arr[cur1++];
            else temp[cur++] = arr[cur2++];
        }
        System.arraycopy(arr, cur1 <= mid ? cur1 : cur2, temp, cur, right - cur + 1);
        System.arraycopy(temp, left, arr, left, right - left + 1);//������ʱ���鿽����ԭ����
    }
}
