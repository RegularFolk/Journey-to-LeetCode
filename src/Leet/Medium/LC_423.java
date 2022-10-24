package Leet.Medium;

import java.util.*;

public class LC_423 {
    //利用单词中字母的独特性,脑筋急转弯
    public static String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {  //统计各字母出现次数
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int[] ch = new int[10];
        ch[0] = map.getOrDefault('z', 0);
        ch[2] = map.getOrDefault('w', 0);
        ch[4] = map.getOrDefault('u', 0);
        ch[6] = map.getOrDefault('x', 0);
        ch[8] = map.getOrDefault('g', 0);
        ch[3] = map.getOrDefault('h', 0) - ch[8];
        ch[5] = map.getOrDefault('f', 0) - ch[4];
        ch[7] = map.getOrDefault('s', 0) - ch[6];
        ch[9] = map.getOrDefault('i', 0) - ch[6] - ch[5] - ch[8];
        ch[1] = map.getOrDefault('o', 0) - ch[0] - ch[2] - ch[4];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(String.valueOf((char) ('0' + i)).repeat(Math.max(0, ch[i])));
        }
        return sb.toString();
    }
}
