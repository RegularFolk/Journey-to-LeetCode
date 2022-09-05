package Hard;

import org.junit.Test;

public class LC_76 {
    /*
     * 滑动窗口应用题
     * 细节爆炸
     * */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] dic = new int[58], clone = new int[58];
        char[] sc = s.toCharArray(), tc = t.toCharArray();
        for (char c : tc) {
            dic[c - 'A']++;
            clone[c - 'A']++;
        }
        int l = 0, r = 0, count;
        String ans = "";
        while (l < s.length() && r < s.length()) {
            while (l < s.length() && dic[sc[l] - 'A'] == 0) l++;
            if (l == s.length()) break;
            r = l - 1;
            count = 0;
            while (count < t.length() && ++r < s.length()) {
                if (clone[sc[r] - 'A'] > 0) {
                    clone[sc[r] - 'A']--;
                    count++;
                }
            }
            if (r < s.length()) {//找到符合题意的
                if (r - l + 1 < ans.length() || ans.equals("")) {
                    ans = String.valueOf(sc, l, r - l + 1);
                }
                l++;
                System.arraycopy(dic, 0, clone, 0, dic.length);
            }
        }
        return ans;
    }

    @Test
    public void s() {
        String s = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}
