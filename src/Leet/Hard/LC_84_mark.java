package Leet.Hard;

import java.util.Stack;

public class LC_84_mark {
    /*
     * ����ջ�Ľ���Ӧ��
     * ��ÿһ�����ӣ������Ե�ǰ����Ϊ�ߵ����
     * ջ�ڴ洢�±꣬����ջ��������һ��Ԫ������ߵ�һ��С�����ģ�
     * ����ǰԪ��С��ջ������ջ���ұߵ�һ��С�ڵ�Ҳ�ҵ���
     * */
    public int largestRectangleArea(int[] heights) {
        int[] copy = new int[heights.length + 2];
        System.arraycopy(heights, 0, copy, 1, heights.length);
        heights = copy;//ͷβ��0�Ƿ��㴦���һ�������һ������
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
