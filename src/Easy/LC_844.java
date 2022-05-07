package Easy;

import java.util.Scanner;

public class LC_844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        if (backspaceCompare(s, t)) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }

    public static boolean backspaceCompare(String s, String t) {
        char[] stackS = new char[s.length()];
        char[] stackT = new char[t.length()];
        int topS = -1;
        int topT = -1;
        int max = Math.max(s.length(), t.length());
        for (int i = 0; i < max; i++) {
            if (i < s.length()) {
                if (s.charAt(i) != '#') {
                    topS++;
                    stackS[topS] = s.charAt(i);
                } else if (topS >= 0) {
                    stackS[i] = '0';
                    topS--;
                }
            }
            if (i < t.length()) {
                if (t.charAt(i) != '#') {
                    topT++;
                    stackT[topT] = t.charAt(i);
                } else if (topT >= 0) {
                    stackT[i] = '0';
                    topT--;
                }
            }
        }
        if (topS != topT) {
            return false;
        }
        for (int i = 0; i <= topS; i++) {
            if (stackS[i] != stackT[i]) {
                return false;
            }
        }
        return true;
    }
}
