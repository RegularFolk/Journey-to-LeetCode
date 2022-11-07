package LeetCode.Easy;

import java.util.Scanner;

public class LC_1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(removeOuterParentheses(s));
    }

    public static String removeOuterParentheses(String s) {//栈只是一种思想，未必得构造一个出来
        int count = 0;
        int top = -1;
        StringBuilder s1 = new StringBuilder(s);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                top++;
            } else {
                count--;
                top++;
                if (count == 0) {
                    if (top > 1) {
                        output.append(s1.subSequence(i - top + 1, i));
                    }
                    top = -1;
                }
            }
        }
        return output.toString();
    }
}
