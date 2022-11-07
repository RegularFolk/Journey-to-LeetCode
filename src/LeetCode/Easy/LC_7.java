package LeetCode.Easy;/*
给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
如果反转后整数超过 32 位的有符号整数的范围，就返回 0。
假设环境不允许存储 64 位整数（有符号或无符号）。
*/

import java.util.Scanner;
import java.lang.Math;

/*
有两种方法，字符串处理方法和数学处理方法
没有处理好越界判断，直接把测试点 if 掉了。。。。。
*/

public class LC_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        x = sc.nextInt();
        StringBuilder s0 = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        s0.append(x);
        if (x < 0) {
            temp.append(s0, 1, s0.length());
            temp.reverse();
            s0.replace(1, s0.length(), temp.toString());
        } else {
            s0.reverse();
        }
        if (s0.length() != 1) {
            for (int i = 0; i < s0.length(); i++) {
                if (s0.charAt(i) == '0') {
                    s0.deleteCharAt(i);
                    i--;
                } else {
                    break;
                }
            }
        }
        System.out.println(s0);
        int ans = 0;
        for (int i = 0; i < s0.length() && s0.charAt(s0.length() - i - 1) != '-'; i++) {
            ans = ans + (s0.charAt(s0.length() - i - 1) - '0') * (int) Math.pow(10, i);
        }
        if (s0.charAt(0) == '-') {
            ans = -ans;
        }
        System.out.println(ans);
//        int x0 = Math.abs(x);
//        int n = (int) Math.log10(x0) + 1;
//        int ans = 0;
//        int temp1;
//        int temp2;
//        int temp3;
//        for (int i = 0; i < n; i++) {
//            temp1 = (int) Math.pow(10, i + 1);
//            temp2 = (int) Math.pow(10, i);
//            temp3 = (int) Math.pow(10, n - 1 - i);
//            ans += (x0 % temp1 / temp2) * temp3;
//        }
//        if (x < 0) {
//            ans = -ans;
//        }
//        System.out.println(ans);
    }
}
