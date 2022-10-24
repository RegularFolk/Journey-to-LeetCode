package Leet.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC_205 {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            map.put(t.charAt(i), Character.MAX_VALUE);
        }
        int count = map.size();
        for (int i = 0; i < len; i++) {
            char si = s.charAt(i), ti = t.charAt(i), value = map.get(ti);
            boolean beenUsed = used.contains(si), taken = value != Character.MAX_VALUE;
            if (beenUsed ^ taken || taken && value != si) {
                return false;
            } else if (!beenUsed) {
                used.add(si);
                map.put(ti, si);
                count--;
            }
        }
        return count == 0;
    }
}
