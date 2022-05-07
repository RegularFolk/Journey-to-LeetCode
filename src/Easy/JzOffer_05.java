package Easy;

import java.util.Scanner;

public class JzOffer_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
//        StringBuilder s0 = new StringBuilder(s);
//        for (int i = 0; i < s0.length(); i++) {
//            if (s0.charAt(i) == ' ') {
//                s0.deleteCharAt(i);
//                s0.insert(i,"%20");
//                i = i + 2;
//            }
//        }
        System.out.println(s.replace(" ","%20"));

        //String 类下的成员方法 replace ，将原字符串中所有目标字符串替换成指定字符串，
        // 返回替换后的字符串，不改变原字符串。
        //StringBuilder 中的 replace 方法功能与这个不同

    }
}
