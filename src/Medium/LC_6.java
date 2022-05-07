package Medium;

import java.util.Scanner;

public class LC_6 {    //寻找数学规律，无需模拟
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int numRows = sc.nextInt();
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {  //行数为1的话内存会爆。。。
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                for (int j = 0; j < s.length(); j += (numRows - 1) * 2) {
                    stringBuilder.append(s.charAt(j));
                }
            } else if (i < numRows - 1) {
                for (int j = 1; j <= numRows - 2; j++) {
                    for (int k = j; k < s.length(); k += (numRows - 1) * 2) {
                        stringBuilder.append(s.charAt(k));
                        if ((k + ((numRows - j - 1) * 2)) < s.length()) {
                            stringBuilder.append(s.charAt(k + ((numRows - j - 1) * 2)));
                        }
                    }
                    i++;
                }
                i--;
            } else {
                for (int j = numRows - 1; j < s.length(); j += (numRows - 1) * 2) {
                    stringBuilder.append(s.charAt(j));
                }
            }
        }
        return stringBuilder.toString();
    }

}
