package Leet.Hard;

import java.util.Stack;

public class LC_85 {
    /*
     * 将每一层看做是一个柱状图，
     * 对每一层求柱状图中的最大矩形，参照LC_84
     * */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int max = 0;
        int[] heights = new int[matrix[0].length];
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (chars[j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            max = Math.max(max, largestRectangleArea(heights));
        }
        return max;
    }

    private int largestRectangleArea(int[] heights) {
        int[] copy = new int[heights.length + 2];
        System.arraycopy(heights, 0, copy, 1, heights.length);
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < copy.length; i++) {
            while (!stack.isEmpty() && copy[stack.peek()] > copy[i]) {
                int height = copy[stack.pop()], width = i - stack.peek() - 1;
                max = Math.max(height * width, max);
            }
            stack.push(i);
        }
        return max;
    }
}
