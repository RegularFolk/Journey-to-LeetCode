package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    给定一个长度为 n 的整数数列，请你计算数列中的逆序对的数量。

    逆序对的定义如下：对于数列的第 i 个和第 j 个元素，如果满足 i<j 且 a[i]>a[j]，则其为一个逆序对；否则不是。

    输入格式
    第一行包含整数 n，表示数列的长度。

    第二行包含 n 个整数，表示整个数列。

    输出格式
    输出一个整数，表示逆序对的个数。

    数据范围
    1≤n≤100000，
    数列中的元素的取值范围 [1,109]。

    输入样例：
    6
    2 3 4 5 6 1
    输出样例：
    5
* */
//归并排序，每次后面摆到前面就计数
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











