package JzOffer;

import java.util.Stack;

public class JzOffer_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int cur1 = 0, cur2 = 0;
        while (cur1 <= pushed.length && cur2 < pushed.length) {
            if (stack.size() == 0 || stack.peek() != popped[cur2]) {
                if (cur1 == pushed.length) {
                    return false;
                }
                stack.push(pushed[cur1++]);
            } else {
                stack.pop();
                cur2++;
            }
        }
        return stack.size() == 0 && cur2 == popped.length;
    }
}
