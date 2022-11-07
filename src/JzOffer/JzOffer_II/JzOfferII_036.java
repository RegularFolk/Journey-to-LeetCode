package JzOffer.JzOffer_II;

import java.util.Stack;

public class JzOfferII_036 {
    /*
     * 后缀表达式计算
     * 借助一个记录数值的栈即可
     * */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOp(token)) doOp(stack, token);
            else stack.push(Integer.valueOf(token));
        }
        return stack.peek();
    }

    private void doOp(Stack<Integer> stack, String token) {
        int b = stack.pop();
        int a = stack.pop();
        int res = 0;
        if ("+".equals(token)) res = a + b;
        else if ("-".equals(token)) res = a - b;
        else if ("*".equals(token)) res = a * b;
        else if ("/".equals(token)) res = a / b;
        stack.push(res);
    }

    private boolean isOp(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }
}
