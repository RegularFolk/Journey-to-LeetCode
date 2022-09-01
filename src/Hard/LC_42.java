package Hard;

import org.junit.Test;

import java.util.Stack;

public class LC_42 {
    /*
     * 单调栈的应用，栈中存储下标
     * 需要连续在栈中取两个，有点抽象
     * */
    public int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int curWidth = i - left - 1;
                int curHei = Math.min(height[left], height[i]) - height[top];
                ans += curWidth * curHei;
            }
            stack.push(i);
        }
        return ans;
    }

    @Test
    public void s() {
        int trap = trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println("trap = " + trap);
    }

}
