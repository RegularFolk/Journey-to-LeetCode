package LeetCode.Medium;

import org.junit.Test;

public class LC_3 {

    /*
     * 一个bit位表示是否出现过
     * 双指针
     * */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        boolean[] map = new boolean[130];
        int l = 0, r = 0, ans = 0, count = 0;
        while (r < chars.length) {
            //当前字符没有出现过，左指针右移
            while (map[chars[r]] && l <= r) {
                map[chars[l]] = false;
                l++;
                count--;
            }
            count++;
            map[chars[r]] = true;
            r++;
            ans = Math.max(ans, count);
        }
        return ans;
    }

    @Test
    public void x() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
