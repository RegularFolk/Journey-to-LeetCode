package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    输入一个长度为 n 的整数序列。

    接下来输入 m 个操作，每个操作包含三个整数 l,r,c，表示将序列中 [l,r] 之间的每个数加上 c。

    请你输出进行完所有操作后的序列。

    输入格式
    第一行包含两个整数 n 和 m。

    第二行包含 n 个整数，表示整数序列。

    接下来 m 行，每行包含三个整数 l，r，c，表示一个操作。

    输出格式
    共一行，包含 n 个整数，表示最终序列。

    数据范围
    1≤n,m≤100000,
    1≤l≤r≤n,
    ?1000≤c≤1000,
    ?1000≤整数序列中元素的值≤1000
    输入样例：
    6 3
    1 2 2 1 2 1
    1 3 1
    3 5 1
    1 6 1
    输出样例：
    3 4 5 3 4 2
* */
public class AW_797 {
    public static void main(String[] args) {
        int[] ints = AWUtils.intsInput();
        int n = ints[0], m = ints[1];
        int[] arr = AWUtils.intArrayInput(n);
        int[][] ops = AWUtils.intsArrayInput(m);
        int[] ans = diff(arr, ops);
        AWUtils.printArrayInline(ans);
    }

    private static int[] diff(int[] arr, int[][] ops) {
        int[] b = new int[arr.length];
        for (int[] op : ops) {
            b[op[0] - 1] += op[2];
            if (op[1] < b.length) b[op[1]] -= op[2];
        }
        arr[0] += b[0];
        for (int i = 1; i < arr.length; i++) {
            b[i] += b[i - 1];
            arr[i] += b[i];
        }
        return arr;
    }
}
