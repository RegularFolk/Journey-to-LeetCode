package Leet.Medium;

import java.util.Scanner;

public class LC_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = (int) Math.log10(num) + 1; i > 0; i--) {   //�������ɸߵ�����λ����
            int temp = num / (int) Math.pow(10, i - 1) % 10;   //��Ӧ��λ������ֵ
            if (i == 4) {   //����ǧλ
                stringBuilder.append("M".repeat(Math.max(0, temp)));
            } else if (i == 3) {  //�����λ
                if (temp == 4) {  //400
                    stringBuilder.append("CD");
                } else if (temp == 9) { //900
                    stringBuilder.append("CM");
                } else if (temp >= 5) {
                    stringBuilder.append("D");
                    stringBuilder.append("C".repeat(Math.max(0, temp - 5)));
                } else {
                    stringBuilder.append("C".repeat(Math.max(0, temp)));
                }
            } else if (i == 2) {//����ʮλ
                if (temp == 4) { //40
                    stringBuilder.append("XL");
                } else if (temp == 9) {//90
                    stringBuilder.append("XC");
                } else if (temp >= 5) {
                    stringBuilder.append("L");
                    stringBuilder.append("X".repeat(Math.max(0, temp - 5)));
                } else {
                    stringBuilder.append("X".repeat(Math.max(0, temp)));
                }
            } else {
                if (temp == 4) {//4
                    stringBuilder.append("IV");
                } else if (temp == 9) {
                    stringBuilder.append("IX");
                } else if (temp >= 5) {
                    stringBuilder.append("V");
                    stringBuilder.append("I".repeat(Math.max(0, temp - 5)));
                } else {
                    stringBuilder.append("I".repeat(Math.max(0, temp)));
                }
            }
        }
        return stringBuilder.toString();
    }
}
