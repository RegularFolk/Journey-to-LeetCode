package JzOffer.JzOffer_I;

import java.util.Stack;

public class JzOffer_30 {
    Stack<Integer> stack;
    Stack<Integer> assist;

    /**
     * initialize your data structure here.
     */
    public JzOffer_30() {
        stack = new Stack<>();
        assist = new Stack<>();
    }

    public void push(int x) {
        assist.push(assist.size() > 0 ? Math.min(x, assist.peek()) : x);
        stack.push(x);
    }

    public void pop() {
        assist.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return assist.peek();
    }
}
