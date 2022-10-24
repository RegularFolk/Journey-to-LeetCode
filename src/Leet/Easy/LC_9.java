package Leet.Easy;

import java.util.Scanner;

public class LC_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        StringBuilder s0 = new StringBuilder();
        s0.append(x);
        boolean flag = true;
        for (int i = 0, j = s0.length() - 1; i <= j; i++, j--) {
            if (s0.charAt(i) != s0.charAt(j)) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}
