package AcWing.Chapter2;

import AcWing.util.AWUtils;

import java.util.LinkedList;
/*
    给定一个大小为 n≤106 的数组。

    有一个大小为 k 的滑动窗口，它从数组的最左边移动到最右边。

    你只能在窗口中看到 k 个数字。

    每次滑动窗口向右移动一个位置。

    以下是一个例子：

    该数组为 [1 3 -1 -3 5 3 6 7]，k 为 3。

    窗口位置	最小值	最大值
    [1 3 -1] -3 5 3 6 7	-1	3
    1 [3 -1 -3] 5 3 6 7	-3	3
    1 3 [-1 -3 5] 3 6 7	-3	5
    1 3 -1 [-3 5 3] 6 7	-3	5
    1 3 -1 -3 [5 3 6] 7	3	6
    1 3 -1 -3 5 [3 6 7]	3	7
    你的任务是确定滑动窗口位于每个位置时，窗口中的最大值和最小值。

    输入格式
    输入包含两行。

    第一行包含两个整数 n 和 k，分别代表数组长度和滑动窗口的长度。

    第二行有 n 个整数，代表数组的具体数值。

    同行数据之间用空格隔开。

    输出格式
    输出包含两个。

    第一行输出，从左至右，每个位置滑动窗口中的最小值。

    第二行输出，从左至右，每个位置滑动窗口中的最大值。

    输入样例：
    8 3
    1 3 -1 -3 5 3 6 7
    输出样例：
    -1 -3 -3 -3 3 3
    3 3 5 5 6 7
* */
public class AW_154 {
    public static void main(String[] args) {
        int[] ints = AWUtils.intsInput();
        int n = ints[0], k = ints[1];
        int[] arr = AWUtils.intArrayInput(n);
        int[][] ans = slidingWid(arr, k);
        AWUtils.printArrayInline(ans[0]);
        System.out.println();
        AWUtils.printArrayInline(ans[1]);
    }

    //利用两个单调队列
    private static int[][] slidingWid(int[] arr, int k) {
        int wins = arr.length - k + 1;
        int[][] ans = new int[2][wins];
        LinkedList<Integer> big = new LinkedList<>();
        LinkedList<Integer> small = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            while (!big.isEmpty() && arr[big.getLast()] < arr[i]) big.removeLast();
            big.addLast(i);
            while (!small.isEmpty() && arr[small.getLast()] > arr[i]) small.removeLast();
            small.addLast(i);
        }
        for (int i = 0; i < wins; i++) {
            int index = i + k - 1;
            while (!big.isEmpty() && arr[big.getLast()] < arr[index]) big.removeLast();
            big.addLast(index);
            while (!small.isEmpty() && arr[small.getLast()] > arr[index]) small.removeLast();
            small.addLast(index);
            ans[0][i] = arr[small.getFirst()];
            ans[1][i] = arr[big.getFirst()];
            if (big.getFirst() == i) big.removeFirst();
            if (small.getFirst() == i) small.removeFirst();
        }
        return ans;
    }
}
