package LeetCode.Medium;

import java.util.*;

public class LC_890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        Set<Character> used = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();
        int length = pattern.length();
        for (int i = 0; i < length; i++) {
            char key = pattern.charAt(i);
            if (!map.containsKey(key)) {
                map.put(key, '!');
            }
        }
        for (String word : words) {
            boolean flag = true;
            int count = map.size();
            for (int i = 0; i < length; i++) {
                char pi = pattern.charAt(i), wi = word.charAt(i), value = map.get(pi);
                boolean beenUsed = used.contains(wi), taken = value != '!';
                if (beenUsed ^ taken || taken && value != wi) {
                    flag = false;
                    break;
                } else if (!beenUsed) {
                    used.add(wi);
                    map.put(pi, wi);
                    count--;
                }
            }
            if (flag && count == 0) {
                ans.add(word);
            }
            initialize(map);
            used.clear();
        }
        return ans;
    }

    private void initialize(Map<Character, Character> map) {
        Set<Map.Entry<Character, Character>> entries = map.entrySet();
        for (Map.Entry<Character, Character> entry : entries) {
            entry.setValue('!');
        }
    }
}
