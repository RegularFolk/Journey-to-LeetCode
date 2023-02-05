package JzOffer.JzOffer_II;

import java.util.Stack;

public class JzOfferII_038 {
    /*
     * ����ջģ����
     *   �����ݼ�ջ,�洢�����±�
     * */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
