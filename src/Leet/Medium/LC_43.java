package Leet.Medium;

import java.util.Scanner;

public class LC_43 {
    public static void main(String[] args) {
        //实际上实现了任意数位的整数相乘
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        String s1;
        String s2;
        if (num1.length() >= num2.length()) {  //保证长的在上面
            s1 = num1;
            s2 = num2;
        } else {
            s1 = num2;
            s2 = num1;
        }
        int min = s2.length() - 1;
        int max = s1.length() - 1;
        int border = max + min;
        int sum;
        int carry = 0;
        int insert;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= border; i++) {   //当前积计算到的位数
            sum = 0;        //sum需要初始化
            int j;
            for (j = i > max ? i - max : 0; j <= i && j <= min; j++) {  //取到的下方乘数的位数
                sum += (s2.charAt(min - j) - '0') * (s1.charAt(max - (i - j)) - '0');
            }
            sum += carry; //加上进位
            insert = sum % 10;
            stringBuilder.insert(0, insert);
            carry = sum / 10;
            if (j == i - max + 1) {
                break;
            }
        }
        if (carry > 0) {
            stringBuilder.insert(0, carry);
        }
        if (stringBuilder.charAt(0) == '0') {
            return "0";
        }
        return stringBuilder.toString();
    }
}
