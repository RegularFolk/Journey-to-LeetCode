package CrackCodeInterview;

import java.util.Stack;

public class Interview_03_04 {
    private static class MyQueue {
        Stack<Integer> stack;
        Stack<Integer> assist;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack = new Stack<>();
            assist = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            while (stack.size() > 0) {
                assist.push(stack.pop());
            }
            stack.push(x);
            while (assist.size() > 0) {
                stack.push(assist.pop());
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return stack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return stack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.size() == 0;
        }
    }
}
