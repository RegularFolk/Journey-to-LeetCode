package LeetCode.Easy;

import java.util.Stack;

public class LC_232 {
    private static class MyQueue {
        Stack<Integer> queue = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        int len = 0;

        public MyQueue() {

        }

        public void push(int x) {
            len++;
            queue.push(x);
        }

        public int pop() {
            if (len == 1) {
                len--;
                return queue.pop();
            }
            int ans = 0;
            for (int i = 0; i < len - 1; i++) {
                temp.push(queue.pop());
            }
            ans = queue.pop();
            for (int i = 0; i < len - 1; i++) {
                queue.push(temp.pop());
            }
            len--;
            return ans;
        }

        public int peek() {
            if (len == 1) {
                return queue.peek();
            }
            int ans = 0;
            for (int i = 0; i < len - 1; i++) {
                temp.push(queue.pop());
            }
            ans = queue.peek();
            for (int i = 0; i < len - 1; i++) {
                queue.push(temp.pop());
            }
            return ans;
        }

        public boolean empty() {
            return len == 0;
        }
    }

}
