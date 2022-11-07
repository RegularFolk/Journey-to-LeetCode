package LeetCode.Hard;

import java.util.Stack;

public class LC_1106 {
    /*
     * ���ʽ����ı��Σ���������ջ
     * */
    public boolean parseBoolExpr(String expression) {
        Stack<Character> val = new Stack<>();
        Stack<Character> ops = new Stack<>();
        char[] chars = expression.toCharArray();
        for (char aChar : chars) {
            if (isVal(aChar) || aChar == '(' || aChar == '{') {//t����f��������ֱ����ջ
                val.push(aChar);
            } else if (isOp(aChar)) {//�������������ջ
                ops.push(aChar);
            } else if (aChar != ',') {//����������
                char op = ops.pop();
                boolean res = calc(op, val);
                val.push(res ? 't' : 'f');
            }
        }
        while (!ops.isEmpty()) {
            char op = ops.pop();
            boolean res = calc(op, val);
            val.push(res ? 't' : 'f');
        }
        return val.peek() == 't';
    }

    private boolean calc(char op, Stack<Character> val) {
        boolean ans = val.pop() == 't';
        if (val.peek() == '(' || val.peek() == '{' || op == '!') {
            ans = (op == '!') != ans;
        } else {
            while (!val.isEmpty() && val.peek() != '(' && val.peek() != '{') {
                ans = doCalc(ans, op, val.pop() == 't');
            }
        }
        if (!val.isEmpty()) val.pop();
        return ans;
    }

    private boolean doCalc(boolean res, char op, boolean cur) {
        if (op == '&') return res & cur;
        else return res | cur;
    }

    private boolean isOp(char aChar) {
        return aChar == '!' || aChar == '|' || aChar == '&';
    }

    private boolean isVal(char aChar) {
        return aChar == 'f' || aChar == 't';
    }
}
