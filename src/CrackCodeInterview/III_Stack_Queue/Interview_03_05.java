package CrackCodeInterview.III_Stack_Queue;

import java.util.Stack;

public class Interview_03_05 {
    private static class SortedStack {
        Stack<Integer> stack;
        Stack<Integer> assist;

        public SortedStack() {
            stack = new Stack<>();
            assist = new Stack<>();
        }

        public void push(int val) {
            while (stack.size() > 0 && stack.peek() < val) {
                assist.push(stack.pop());
            }
            stack.push(val);
            while (assist.size() > 0) {
                stack.push(assist.pop());
            }
        }

        public void pop() {
            if (!isEmpty()) {
                stack.pop();
            }
        }

        public int peek() {
            return isEmpty() ? -1 : stack.peek();
        }

        public boolean isEmpty() {
            return stack.size() == 0;
        }
    }
}
