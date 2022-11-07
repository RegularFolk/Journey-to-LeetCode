package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    给定一个长度为 n 的数列，请你求出数列中每个数的二进制表示中 1 的个数。

    输入格式
    第一行包含整数 n。

    第二行包含 n 个整数，表示整个数列。

    输出格式
    共一行，包含 n 个整数，其中的第 i 个数表示数列中的第 i 个数的二进制表示中 1 的个数。

    数据范围
    1≤n≤100000,
    0≤数列中元素的值≤109
    输入样例：
    5
    1 2 3 4 5
    输出样例：
    1 1 2 1 2
* */
public class AW_801 {
    public static void main(String[] args) {
        int n = AWUtils.intInput();
        int[] arr = AWUtils.intArrayInput(n);
        int[] ans = count1(arr);
        AWUtils.printArrayInline(ans);
    }

    private static int[] count1(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            while (arr[i] > 0) {
                count += arr[i] & 1;
                arr[i] >>= 1;
            }
            ans[i] = count;
        }
        return ans;
    }
}
