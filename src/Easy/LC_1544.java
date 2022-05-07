package Easy;

import java.util.Scanner;

public class LC_1544 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(makeGood(s));
    }

    public static String makeGood(String s) {
        char[] temp = new char[s.length()];
        int top = 0;
        temp[0] = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (top == -1) {
                top++;
                temp[top] = s.charAt(i);
            } else {
                if (Math.abs(s.charAt(i) - temp[top]) == 32) {
                    temp[top] = '\0';
                    top--;
                } else {
                    top++;
                    temp[top] = s.charAt(i);
                }
            }
        }
        if (top == -1) {
            return "";
        }
        char[] output = new char[top + 1];
        System.arraycopy(temp, 0, output, 0, top + 1);
        return new String(output);
    }
}