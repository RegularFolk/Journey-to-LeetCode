package Leet.Medium;

import java.util.Stack;

public class LC_1003 {
    public static void main(String[] args) {

    }

    public static boolean isValid(String s) {
        if (s.charAt(0) != 'a' || s.charAt(s.length() - 1) != 'c' || s.length() < 3) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        int height = 2;
        char a;
        char b;
        stack.push(s.charAt(0));
        stack.push(s.charAt(1));
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == 'c' && height >= 2) {
                b = stack.pop();
                a = stack.pop();
                if (a != 'a' || b != 'b') {
                    stack.push(a);
                    stack.push(b);
                    stack.push(s.charAt(i));
                    height++;
                } else {
                    height -= 2;
                }
            } else {
                stack.push(s.charAt(i));
                height++;
            }
        }
        return stack.empty();
    }
}
