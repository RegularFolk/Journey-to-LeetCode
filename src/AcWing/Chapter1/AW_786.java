package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    给定一个长度为 n 的整数数列，以及一个整数 k，请用快速选择算法求出数列从小到大排序后的第 k 个数。

    输入格式
    第一行包含两个整数 n 和 k。

    第二行包含 n 个整数（所有整数均在 1?109 范围内），表示整数数列。

    输出格式
    输出一个整数，表示数列的第 k 小数。

    数据范围
    1≤n≤100000,
    1≤k≤n
    输入样例：
    5 3
    2 4 1 5 3
    输出样例：
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
        if (pivot == arr[left]) rank = r;//存在特殊情况，如果全程没有发生交换，则不能加1
        if (rank == tar) return (int) pivot;
        else if (rank > tar) return qPick(arr, tar, left, r);
        else return qPick(arr, tar, r + 1, right);
    }

}
