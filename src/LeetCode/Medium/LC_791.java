package LeetCode.Medium;

import java.util.concurrent.*;

public class LC_791 {
    /*
    * ¼ÆÊýÅÅÐò
    * */
    public String customSortString(String order, String s) {
        int[] map = new int[order.length()];
        StringBuilder builder = new StringBuilder(s.length());
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int indexOf = order.indexOf(s.charAt(i));
            if (indexOf == -1) builder.append(s.charAt(i));
            else map[indexOf]++;
        }
        for (int i = 0; i < map.length; i++) {
            builder.append((order.charAt(i) + "").repeat(map[i]));
        }
        return builder.toString();
    }
}