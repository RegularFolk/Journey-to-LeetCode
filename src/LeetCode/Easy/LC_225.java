package LeetCode.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class LC_225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }

    static class MyStack {
        Queue<Integer> stack = new LinkedList<>();
        Queue<Integer> reverse = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            stack.add(x);
            if (reverse.isEmpty()) {
                reverse.add(x);
            } else {
                reverse.add(x);
                for (int i = 0; i < reverse.size() - 1; i++) {
                    reverse.add(reverse.poll());
                }
            }
        }

        public int pop() {
            int ans = reverse.poll();
            int len = reverse.size();
            for (int i = 0; i < len; i++) {
                reverse.add(stack.poll());
            }
            stack.poll();
            for (int i = 0; i < len; i++) {
                stack.add(reverse.poll());
            }
            Queue<Integer> temp = stack;
            stack = reverse;
            reverse = temp;
            return ans;
        }

        public int top() {
            return reverse.peek();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }
}
