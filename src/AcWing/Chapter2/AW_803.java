package AcWing.Chapter2;

import AcWing.util.AWUtils;

import java.util.Stack;

/*
    给定一个长度为 N 的整数数列，输出每个数左边第一个比它小的数，如果不存在则输出 ?1。

    输入格式
    第一行包含整数 N，表示数列长度。

    第二行包含 N 个整数，表示整数数列。

    输出格式
    共一行，包含 N 个整数，其中第 i 个数表示第 i 个数的左边第一个比它小的数，如果不存在则输出 ?1。

    数据范围
    1≤N≤105
    1≤数列中元素≤109
    输入样例：
    5
    3 4 2 7 5
    输出样例：
    -1 3 -1 2 2
* */
public class AW_803 {
    public static void main(String[] args) {
        int n = AWUtils.intInput();
        int[] arr = AWUtils.intArrayInput(n);
        int[] ans = fistSmaller(arr);
        AWUtils.printArrayInline(ans);
    }

    //单调递增栈，直接存值
    private static int[] fistSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                ans[i] = -1;
            } else if (stack.peek() < arr[i]) {
                ans[i] = stack.peek();
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() >= arr[i]) stack.pop();
                if (!stack.isEmpty()) ans[i] = stack.peek();
                else ans[i] = -1;
                stack.push(arr[i]);
            }
        }
        return ans;
    }
}
