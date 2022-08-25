package CrackCodeInterview.I_Array_String;

import java.util.HashMap;
import java.util.Map;

public class Interview_01_04 {
    public boolean canPermutePalindrome(String s) { //至多一个字符出现奇数次
        if (s == null || s.length() == 0) {
            return false;
        }
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            Integer time = map.getOrDefault(sc, 0);
            if ((time & 1) == 0) {
                count++;
            } else {
                count--;
            }
            map.put(sc, time + 1);
        }
        return count <= 1;
    }
}
