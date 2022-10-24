package Leet.Medium;

import java.util.HashMap;
import java.util.Map;
//用哈希表效率比较低
public class LC_3 {
    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            for (int j = i; j < s.length(); j++) {
                if (!map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), j);
                    count++;
                } else {
                    i = map.get(s.charAt(j));
                    map.clear();
                    break;
                }
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}
