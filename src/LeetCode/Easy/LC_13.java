package LeetCode.Easy;

import java.util.Scanner;

public class LC_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s0 = new String(sc.nextLine());
        int ans = 0;
        for (int i = 0; i < s0.length(); i++) {
            if (s0.charAt(i) == 'M') {
                ans += 1000;
            } else if (s0.charAt(i) == 'D') {
                ans += 500;
            } else if (s0.charAt(i) == 'C') {
                ans += 100;
            } else if (s0.charAt(i) == 'L') {
                ans += 50;
            } else if (s0.charAt(i) == 'X') {
                ans += 10;
            } else if (s0.charAt(i) == 'V') {
                ans += 5;
            } else {
                ans++;
            }
        }
        for (int i = 0; i < s0.length() - 1; i++) {
            if (s0.charAt(i) == 'I' & (s0.charAt(i + 1) == 'V' | s0.charAt(i + 1) == 'X')) {
                ans -= 2;
            } else if (s0.charAt(i) == 'X' & (s0.charAt(i + 1) == 'L' | s0.charAt(i + 1) == 'C')) {
                ans -= 20;
            } else if (s0.charAt(i) == 'C' & (s0.charAt(i + 1) == 'D' | s0.charAt(i + 1) == 'M')) {
                ans -= 200;
            }
        }
        System.out.println(ans);
    }
}
