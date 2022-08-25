package CrackCodeInterview.III_Stack_Queue;

import java.util.Stack;

public class Interview_03_02 {//最小栈问题--------》（栈和队列的最值维护问题）
    private static class MinStack {
        Stack<Integer> stack;
        Stack<Integer> min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            stack.add(x);
            min.push(min.size() == 0 ? x : Math.min(min.peek(), x));
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
