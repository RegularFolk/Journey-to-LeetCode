package Leet.Easy;

import java.util.HashMap;
import java.util.Map;

public class LC_895 {
    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        boolean ans = true;
        boolean complete = false;
        boolean multi = false;
        for (int i = 0; i < s.length(); i++) {
            boolean compare = s.charAt(i) != goal.charAt(i);
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                multi = true;
            }
            if (compare && !complete) {
                ans = false;
                int mark = i;
                for (int j = i + 1; j < s.length(); j++) {
                    if (goal.charAt(j) == s.charAt(mark) && goal.charAt(mark) == s.charAt(j)) {
                        ans = true;
                        complete = true;
                        i = j;
                        break;
                    } else if (goal.charAt(j) != s.charAt(j)) {
                        return false;
                    }
                    i = j;
                }
            } else if (complete && compare) {
                ans = false;
                break;
            }
        }
        if (!complete && !multi) {
            ans = false;
        }
        return ans;
    }

    public static boolean buddyStrings2(String s, String goal) {
        if (s.equals(goal)) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int pos = s.charAt(i) - 'a';
                if (count[pos] == 0) {
                    count[pos]++;
                } else {
                    return true;
                }
            }
            return false;
        } else {
            int first = -1;
            int second = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else {
                        return false;
                    }
                }
            }
            return first != -1 && second != -1 && s.charAt(first) == goal.charAt(second)
                    && s.charAt(second) == goal.charAt(first) && s.length() == goal.length();
        }
    }
}
