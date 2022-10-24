package AcWing.Chapter1;

import AcWing.util.AWUtils;

/*
    给定一个按照升序排列的长度为 n 的整数数组，以及 q 个查询。

    对于每个查询，返回一个元素 k 的起始位置和终止位置（位置从 0 开始计数）。

    如果数组中不存在该元素，则返回 -1 -1。

    输入格式
    第一行包含整数 n 和 q，表示数组长度和询问个数。

    第二行包含 n 个整数（均在 1?10000 范围内），表示完整数组。

    接下来 q 行，每行包含一个整数 k，表示一个询问元素。

    输出格式
    共 q 行，每行包含两个整数，表示所求元素的起始位置和终止位置。

    如果数组中不存在该元素，则返回 -1 -1。

    数据范围
    1≤n≤100000
    1≤q≤10000
    1≤k≤10000
    输入样例：
    6 3
    1 2 2 3 3 4
    3
    4
    5
    输出样例：
    3 4
    5 5
    -1 -1
* */
public class AW_789 {

    public static void main(String[] args) {
        int[] ints = AWUtils.intsInput();
        int n = ints[0], q = ints[1];
        int[] arr = AWUtils.intArrayInput(n);
        int[] queries = AWUtils.intsInputLineByLine(q);
        int[][] ans = new int[q][2];
        for (int i = 0; i < queries.length; i++) {
            ans[i][0] = findLeft(arr, queries[i]);
            ans[i][1] = findRight(arr, queries[i]);
        }
        AWUtils.printDoubleArray(ans);
    }

    private static int findRight(int[] arr, int query) {
        int l = 0, r = arr.length - 1, pos = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (arr[mid] <= query) {
                if (arr[mid] == query) pos = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return pos;
    }

    private static int findLeft(int[] arr, int query) {
        int l = 0, r = arr.length - 1, pos = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (arr[mid] < query) {
                l = mid + 1;
            } else {
                if (arr[mid] == query) pos = mid;
                r = mid - 1;
            }
        }
        return pos;
    }

}
