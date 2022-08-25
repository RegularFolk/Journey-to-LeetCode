package CrackCodeInterview.I_Array_String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Interview_01_02 {
    public boolean CheckPermutation1(String s1, String s2) { //维护一个哈希表
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            Integer mapValue = map.getOrDefault(c, 0);
            if (mapValue == 0) {
                return false;
            } else {
                map.put(c, mapValue - 1);
            }
        }
        return true;
    }

    public boolean CheckPermutation2(String s1, String s2) { //排序后逐一比较
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()) {
            return false;
        }
        char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }
}
