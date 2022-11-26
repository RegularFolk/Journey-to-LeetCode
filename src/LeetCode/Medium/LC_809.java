package LeetCode.Medium;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

public class LC_809 {
    /*
    * 双指针应用题
    * */
    public int expressiveWords(String s, String[] words) {
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>();
        char[] sc = s.toCharArray();
        int ans = 0, l = 0, r = 0;
        while (r < sc.length) {
            while (r < sc.length && sc[r] == sc[l]) r++;
            list.add(new AbstractMap.SimpleEntry<>(sc[l], r - l));
            l = r;
        }
        for (String word : words) {
            if (word.length() > s.length()) continue;
            int lc = 0, rc = 0, cur = 0;
            char[] chars = word.toCharArray();
            while (rc < chars.length) {
                while (rc < chars.length && chars[rc] == chars[lc]) rc++;
                Map.Entry<Character, Integer> entry = list.get(cur);
                if (entry.getKey() != chars[lc] || (entry.getValue() < 3 && entry.getValue() != rc - lc) || rc - lc > entry.getValue())
                    break;
                cur++;
                lc = rc;
            }
            if (cur == list.size()) ans++;
        }
        return ans;
    }
}
