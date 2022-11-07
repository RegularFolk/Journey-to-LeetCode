package LeetCode.Easy;/*
给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
*/

import java.util.Scanner;

/*
直接模拟，利用StringBuilder类下的成员方法。
*/

public class LC_541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder s0 = new StringBuilder();
        int k;
        int count = 1;
        s0.append(sc.nextLine());
        k = sc.nextInt();
        for (; count * 2 * k <= s0.length(); count++) {
            StringBuilder temp = new StringBuilder();
            temp.append(s0, (count - 1) * 2 * k, (2 * count - 1) * k);
            temp.reverse();
            s0.replace((count - 1) * 2 * k, (2 * count - 1) * k, temp.toString());
        }
        count--;
        if (s0.length() - count * 2 * k < k) {
            StringBuilder temp = new StringBuilder();
            temp.append(s0, count * 2 * k, s0.length());
            temp.reverse();
            s0.replace(count * 2 * k, s0.length(), temp.toString());
        } else if (s0.length() - count * 2 * k < 2 * k) {
            StringBuilder temp = new StringBuilder();
            temp.append(s0, count * 2 * k, count * 2 * k + k);
            temp.reverse();
            s0.replace(count * 2 * k, count * 2 * k + k, temp.toString());
        }
        System.out.println(s0);
    }
}
