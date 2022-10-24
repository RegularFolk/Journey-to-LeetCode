package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    ����һ������Ϊ n ���������У�������������е�����Ե�������

    ����ԵĶ������£��������еĵ� i ���͵� j ��Ԫ�أ�������� i<j �� a[i]>a[j]������Ϊһ������ԣ������ǡ�

    �����ʽ
    ��һ�а������� n����ʾ���еĳ��ȡ�

    �ڶ��а��� n ����������ʾ�������С�

    �����ʽ
    ���һ����������ʾ����Եĸ�����

    ���ݷ�Χ
    1��n��100000��
    �����е�Ԫ�ص�ȡֵ��Χ [1,109]��

    ����������
    6
    2 3 4 5 6 1
    ���������
    5
* */
//�鲢����ÿ�κ���ڵ�ǰ��ͼ���
public class AW_788 {
    static long ans = 0;

    public static void main(String[] args) {
        int n = AWUtils.intInput();
        long[] arr = AWUtils.longArrayInput(n);
        mergeSort(arr, new long[n], 0, n - 1);
        System.out.println(ans);
    }

    private static void mergeSort(long[] arr, long[] temp, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) >> 1;
        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);
        int cur1 = left, cur2 = mid + 1, cur = left;
        while (cur1 <= mid && cur2 <= right) {
            if (arr[cur1] <= arr[cur2]) temp[cur++] = arr[cur1++];
            else {
                temp[cur++] = arr[cur2++];
                ans += mid - cur1 + 1;//<<<
            }
        }
        System.arraycopy(arr, cur1 <= mid ? cur1 : cur2, temp, cur, right - cur + 1);
        System.arraycopy(temp, left, arr, left, right - left + 1);
    }
}











