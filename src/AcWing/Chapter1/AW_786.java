package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    ����һ������Ϊ n ���������У��Լ�һ������ k�����ÿ���ѡ���㷨������д�С���������ĵ� k ������

    �����ʽ
    ��һ�а����������� n �� k��

    �ڶ��а��� n �������������������� 1?109 ��Χ�ڣ�����ʾ�������С�

    �����ʽ
    ���һ����������ʾ���еĵ� k С����

    ���ݷ�Χ
    1��n��100000,
    1��k��n
    ����������
    5 3
    2 4 1 5 3
    ���������
    3
* */
public class AW_786 {

    public static void main(String[] args) {
        int[] ints = AWUtils.intsInput();
        int n = ints[0], k = ints[1];
        long[] arr = AWUtils.longArrayInput(n);
        int ans = qPick(arr, k - 1, 0, n - 1);
        System.out.println(ans);
    }

    private static int qPick(long[] arr, int tar, int left, int right) {
        long pivot = arr[left];
        int l = left - 1, r = right + 1;
        while (l < r) {
            do l++; while (arr[l] < pivot);
            do r--; while (arr[r] > pivot);
            if (l < r) AWUtils.swapArray(arr, l, r);
        }
        int rank = r + 1;
        if (pivot == arr[left]) rank = r;//����������������ȫ��û�з������������ܼ�1
        if (rank == tar) return (int) pivot;
        else if (rank > tar) return qPick(arr, tar, left, r);
        else return qPick(arr, tar, r + 1, right);
    }

}
