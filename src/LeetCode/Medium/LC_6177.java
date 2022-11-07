package LeetCode.Medium;

import java.util.Arrays;

public class LC_6177 {
    /*
     * Ì°ÐÄ
     * */
    public int partitionString(String s) {
        int ans = 0, cursor = 0;
        boolean[] rec = new boolean[26];
        char[] chars = s.toCharArray();
        while (cursor < s.length()) {
            while (cursor < s.length() && !rec[chars[cursor] - 'a']) {
                rec[chars[cursor] - 'a'] = true;
                cursor++;
            }
            ans++;
            Arrays.fill(rec, false);
        }
        return ans;
    }
}
