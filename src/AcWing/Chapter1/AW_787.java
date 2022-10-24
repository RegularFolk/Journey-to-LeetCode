package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    给定你一个长度为 n 的整数数列。

    请你使用归并排序对这个数列按照从小到大进行排序。

    并将排好序的数列按顺序输出。

    输入格式
    输入共两行，第一行包含整数 n。

    第二行包含 n 个整数（所有整数均在 1?109 范围内），表示整个数列。

    输出格式
    输出共一行，包含 n 个整数，表示排好序的数列。

    数据范围
    1≤n≤100000
    输入样例：
    5
    3 1 2 4 5
    输出样例：
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
        System.arraycopy(temp, left, arr, left, right - left + 1);//最后把临时数组拷贝回原数组
    }
}
