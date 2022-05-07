package Easy;

import java.util.Scanner;

public class LC_1047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String s) {
        if (s.equals("")) {
            return "";
        }
        char[] stack = new char[s.length()];
        int top = 0;
        stack[0] = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (top >= 0) {
                if (s.charAt(i) != stack[top]) {
                    top++;
                    stack[top] = s.charAt(i);
                } else {
                    stack[top] = '\0';
                    top--;
                }
            } else{
                top++;
                stack[top] = s.charAt(i);
            }
        }
        char[] output = new char[top + 1];
        System.arraycopy(stack, 0, output, 0, top + 1);
        return new String(output);
    }
}
