package LeetCode.Easy;

import java.util.Scanner;

public class LC_20 {
    public static void main(String[] args) {//三种括号等价
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (isValid(s)) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }

    public static boolean isValid(String s) {//利用栈来实现括号判断
        char[] stack = new char[s.length()];
        StringBuilder str = new StringBuilder(s);
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            if (str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '(') {
                top++;
                stack[top] = str.charAt(i);
            } else if (top < 0) {
                return false;
            } else if ((str.charAt(i) == ']' && stack[top] == '[') ||
                    (str.charAt(i) == '}' && stack[top] == '{') ||
                    (str.charAt(i) == ')' && stack[top] == '(')) {
                stack[top] = 'N';
                top--;
            } else {
                return false;
            }
        }
        return stack[0] == 'N';
    }
}
