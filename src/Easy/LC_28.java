package Easy;

import java.util.Scanner;

/*
实现strStr()函数。
给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
如果不存在，则返回-1 。
当needle是空字符串时返回 0 .
*/

/*
暴力算法 or KMP
*/

public class LC_28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String haystack = sc.nextLine();
        String needle = sc.nextLine();
        System.out.println(strStr(haystack, needle));
    }

    //暴力解法
    public static int strStr(String haystack, String needle) {
        if (!needle.equals("")) {
            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                int j = 0;
                if (haystack.charAt(i) == needle.charAt(0)) {
                    for (; j < needle.length(); j++) {
                        if (haystack.charAt(i + j) != needle.charAt(j)) {
                            break;
                        }
                        if (j == needle.length() - 1) {
                            return i;
                        }
                    }
                }
            }
        } else {
            return 0;
        }
        return -1;
    }
}
