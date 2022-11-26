package JzOffer.JzOffer_II;

public class JzOfferII_016 {
    /*
     * 伸缩双指针+二进制数标记出现情况
     * 只支持纯小写字母，可惜本题是任意字符
     * */
    public int lengthOfLongestSubstring(String s) {
        int map = 0, ans = 0, l = 0, r = 0;
        char[] chars = s.toCharArray();
        while (r < chars.length) {
            int offset = chars[r++] - 'a';
            while ((((map >> offset) & 1) == 1) && l < r) map &= ~(1 << (chars[l++] - 'a'));
            map |= 1 << offset;
            ans = Math.max(ans, r - l);
        }
        return ans;
    }

    //任意字符，退而求其次使用数组
    public int lengthOfLongestSubstring1(String s) {
        boolean[] set = new boolean[128];
        int ans = 0, l = 0, r = 0;
        char[] chars = s.toCharArray();
        while (r < chars.length) {
            while (set[chars[r]] && l < r) set[chars[l++]] = false;
            set[chars[r++]] = true;
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
