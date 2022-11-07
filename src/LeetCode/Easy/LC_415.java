package LeetCode.Easy;

import java.util.LinkedList;

public class LC_415 {
    /*
     * Ä£Äâ
     * */
    public String addStrings(String num1, String num2) {
        char[] c1 = num1.toCharArray(), c2 = num2.toCharArray();
        LinkedList<Integer> list = new LinkedList<>();
        int cursor1 = c1.length - 1, cursor2 = c2.length - 1, carry = 0, offSet = 2 * '0';
        while (cursor1 >= 0 && cursor2 >= 0) {
            int sum = c1[cursor1] + c2[cursor2] + carry - offSet;
            list.addFirst(sum % 10);
            carry = sum / 10;
            cursor1--;
            cursor2--;
        }
        char[] left = cursor1 == -1 ? c2 : c1;
        int cur = cursor1 == -1 ? cursor2 : cursor1;
        while (cur >= 0) {
            int sum = left[cur--] + carry - '0';
            list.addFirst(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) list.addFirst(1);
        StringBuilder builder = new StringBuilder();
        for (Integer integer : list) {
            builder.append(integer);
        }
        return builder.toString();
    }
}
