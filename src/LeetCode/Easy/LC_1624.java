package LeetCode.Easy;

import java.util.Arrays;

public class LC_1624 {
    /*
     * ¼òµ¥×Ö·û´®Ä£ÄâÌâ
     * */
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] rec = new int[26];
        Arrays.fill(rec, -1);
        int ans = -1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (rec[index] == -1) rec[index] = i;
            else ans = Math.max(i - rec[index] - 1, ans);
        }
        return ans;
    }
}
