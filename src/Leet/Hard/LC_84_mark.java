package Leet.Hard;

import java.util.Stack;

public class LC_84_mark {
    /*
     * 单调栈的进阶应用
     * 对每一根柱子，计算以当前柱子为高的面积
     * 栈内存储下标，对于栈顶，下面一个元素是左边第一个小于它的，
     * 若当前元素小于栈顶，则栈顶右边第一个小于的也找到了
     * */
    public int largestRectangleArea(int[] heights) {
        int[] copy = new int[heights.length + 2];
        System.arraycopy(heights, 0, copy, 1, heights.length);
        heights = copy;//头尾置0是方便处理第一个和最后一个方块
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return max;
    }

}
