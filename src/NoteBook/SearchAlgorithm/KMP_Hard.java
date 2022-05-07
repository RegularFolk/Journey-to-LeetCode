package NoteBook.SearchAlgorithm;

import java.util.Scanner;

public class KMP_Hard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hayStack = sc.nextLine();
        String needle = sc.nextLine();
//        System.out.println(kmp(hayStack, needle));
//        System.out.println(myKmp(hayStack, needle));
//        int[] next = new int[needle.length() + 1];
//        myGetNext(needle, next);
//        for (int i : next) {
//            System.out.println(i);
//        }
        System.out.println(myKmp(hayStack, needle));
    }

    public static int kmp(String hayStack, String needle) {
        int[] next = new int[needle.length() + 1];
        myGetNext(needle, next);
        String h = " " + hayStack;
        String n = " " + needle;    //将两个字符串前面加上空格，用于适配 next数组 首元素为0
        for (int i = 1, j = 0; i < h.length(); i++) {// i 指着原串， j 指着匹配串
            while (j > 0 && h.charAt(i) != n.charAt(j + 1)) {//匹配不成功时， 对 j 用 next数组 进行赋值,限制 j>0，否则可能会进入死循环
                j = next[j];
            }
            if (j == needle.length()) {// j 走到匹配串末尾，匹配成功
                return i - n.length();
            }
            if (n.charAt(j + 1) == h.charAt(i)) {//当前匹配成功， 让 j 往后移动一格，出去后 i 会跟着移
                j++;
            }//如果匹配串第一个就匹配不上，就跳过循环内所有步骤，直接让 i 往后移动一格
        }
        return -1;
    }

    public static int myKmp(String hayStack, String needle) {//不把两个字符串开头加上空格
        int[] next = new int[needle.length() + 1];
        myGetNext(needle, next);
        for (int i = 0, j = 0; i < hayStack.length(); i++) {
            if (hayStack.charAt(i) == needle.charAt(j)) {//匹配成功
                j++;
            }
            if (j == needle.length()) {//搜索完成
                return i - needle.length() + 1;
            } else if (j > 0 && hayStack.charAt(i) != needle.charAt(j)) {
                j = next[j + 1] - 1;
            }
        }
        return -1;
    }

//    while (h.charAt(i) == n.charAt(j + 1)) {
//        j++;
//        i++;
//    }
//            if (j == n.length() - 1) {//若 j 走到匹配串末尾则匹配成功
//        return i - n.length() + 1;
//    } else if (j > 0) {//若查找到不匹配,若 j==0 此时会进入死循环
//        j = next[j];
//    } else {//若 j==0 就让 i 往后移动一格
//        i++;
//    }

    //获取每个位置之前子串的最大公共前后缀长度，储存在 next 数组中 ,
    public static void getNext(String needle, int[] next) {
        next[0] = 0;//将 next 首元素设置为0,实际上过程中用不着该元素

    }

    public static void myGetNext(String needle, int[] next) {
        next[1] = 0;  //next数组 就是任一位置之前字串的最大相同前后缀长度加1，首元素为0
        int j = 0;  //j 为游标加一
        int i = 1;  //i 为 next数组 的索引加一
        while (i < needle.length()) {
            if (j == 0 || needle.charAt(i - 1) == needle.charAt(j - 1)) {//若匹配成功,即当前next下标对应的字符等于next下标下的值对应的字符
                i++;
                j++;
                next[i] = j;  //next数组的值最大等于上一个值+1，即最顺利的情况下
            } else {
                j = next[j];
            }
        }//最终得到的next数组长度会多一个，多出来的为首元素0
    }
}
