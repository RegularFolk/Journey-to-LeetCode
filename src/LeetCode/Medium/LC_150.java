package LeetCode.Medium;

import java.util.Stack;

public class LC_150 {
    /*
     * 经典栈的应用题
     * */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isNum(token)) {
                stack.add(Integer.parseInt(token));
            } else {
                Integer num2 = stack.pop(), num1 = stack.pop();
                stack.push(compute(token, num1, num2));
            }
        }
        return stack.peek();
    }

    private boolean isNum(String token) {
        return !token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/");
    }

    private int compute(String note, int num1, int num2) {
        return switch (note) {
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            default -> throw new RuntimeException();
        };
    }
}
