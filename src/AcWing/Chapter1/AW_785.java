package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    给定你一个长度为 n 的整数数列。

    请你使用快速排序对这个数列按照从小到大进行排序。

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
public class AW_785 {
    public static void main(String[] args) {
        int n = AWUtils.intInput();
        long[] arrays = AWUtils.longArrayInput(n);
        qSort(arrays, 0, arrays.length - 1);
        AWUtils.printArrayInline(arrays);
    }

    //快速排序
    private static void qSort(long[] arrays, int left, int right) {
        if (left < right) {
            long pivot = arrays[left];
            int l = left - 1, r = right + 1;//先后退一步是为了适配do
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
