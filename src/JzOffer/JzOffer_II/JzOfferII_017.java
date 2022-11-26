package JzOffer.JzOffer_II;


import java.util.LinkedList;
import java.util.Queue;

public class JzOfferII_017 {
    /*
     * 伸缩双指针复杂应用题
     *  时间复杂度为N的实现
     * */
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        Queue<Integer> candidates = new LinkedList<>();
        int[] mark = new int[128];
        boolean[] exist = new boolean[128];
        char[] sc = s.toCharArray(), tc = t.toCharArray();
        for (char c : tc) {
            mark[c]++;
            exist[c] = true;
        }
        int l = 0, r, count = t.length();
        String ans = "";
        while (l < s.length() && !exist[sc[l]]) l++;
        r = l;
        while (r < s.length()) {
            while (count != 0 && r < s.length()) {
                if (exist[sc[r]]) {
                    if (mark[sc[r]] > 0) count--;
                    candidates.add(r);
                    mark[sc[r]]--;
                }
                r++;
            }
            if (count == 0 && (r - l < ans.length() || ans.length() == 0)) ans = s.substring(l, r);
            mark[sc[l]]++;
            if (mark[sc[l]] > 0) count++;
            if (!candidates.isEmpty() && l == candidates.peek()) candidates.poll();
            if (!candidates.isEmpty()) l = candidates.poll();
        }
        while (count == 0) {
            if (r - l < ans.length() || ans.length() == 0)ans = s.substring(l, r);
            mark[sc[l]]++;
            if (mark[sc[l]] > 0) count++;
            if (!candidates.isEmpty() && l == candidates.peek()) candidates.poll();
            if (!candidates.isEmpty()) l = candidates.poll();
        }
        return ans;
    }

}
