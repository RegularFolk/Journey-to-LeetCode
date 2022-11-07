package AcWing.Chapter2;

import AcWing.util.AWUtils;

import java.util.ArrayList;

/*
    给定一个字符串 S，以及一个模式串 P，所有字符串中只包含大小写英文字母以及阿拉伯数字。

    模式串 P 在字符串 S 中多次作为子串出现。

    求出模式串 P 在字符串 S 中所有出现的位置的起始下标。

    输入格式
    第一行输入整数 N，表示字符串 P 的长度。

    第二行输入字符串 P。

    第三行输入整数 M，表示字符串 S 的长度。

    第四行输入字符串 S。

    输出格式
    共一行，输出所有出现位置的起始下标（下标从 0 开始计数），整数之间用空格隔开。

    数据范围
    1≤N≤105
    1≤M≤106
    输入样例：
    3
    aba
    5
    ababa
    输出样例：
    0 2
* */
public class AW_831 {
    public static void main(String[] args) {
        AWUtils.intInput();
        String p = AWUtils.stringInput();
        AWUtils.intsInput();
        String s = AWUtils.stringInput();
        ArrayList<Integer> ans = kmp((" " + p).toCharArray(), (" " + s).toCharArray());
        AWUtils.printListInLint(ans);
    }

    private static ArrayList<Integer> kmp(char[] p, char[] s) {
        int[] next = getNext(p);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1, j = 0; i < s.length; i++) {
            while (j != 0 && s[i] != p[j + 1]) j = next[j];
            if (s[i] == p[j + 1]) j++;
            if (j == p.length - 1) {
                ans.add(i - p.length + 1);
                j = next[j];
            }
        }
        return ans;
    }

    /*
     * next数组的定义:next[i]为下标0~i的子串最长相同前后缀的长度
     * */
    private static int[] getNext(char[] p) {
        int[] next = new int[p.length];
        for (int curNext = 2, curP = 0; curNext < p.length; curNext++) {
            while (curP != 0 && p[curNext] != p[curP + 1]) curP = next[curP];
            if (p[curNext] == p[curP + 1]) curP++;
            next[curNext] = curP;
        }
        return next;
    }
}
