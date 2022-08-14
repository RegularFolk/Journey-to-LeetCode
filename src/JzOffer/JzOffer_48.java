package JzOffer;

import java.util.HashSet;
import java.util.Set;

public class JzOffer_48 {
    public int lengthOfLongestSubstring(String s) {  //经典滑动窗口
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0, cursor = 0;//cursor指向当前维护子串开头
        Set<Character> win = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (win.contains(c)) {
                while (cursor < i) {
                    char temp = s.charAt(cursor);
                    win.remove(temp);
                    cursor++;
                    if (temp == c) {
                        break;
                    }
                }
            }
            win.add(c);
            max = Math.max(max, win.size());
        }
        return max;
    }
}
