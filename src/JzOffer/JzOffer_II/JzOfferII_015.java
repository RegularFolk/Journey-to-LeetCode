package JzOffer.JzOffer_II;


import java.util.ArrayList;
import java.util.List;

public class JzOfferII_015 {
    /*
     * 滑动窗口
     *  滑动窗口类问题的难点在于维护窗口的状态
     * */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) return ans;
        int[] mark = new int[26];
        char[] pChars = p.toCharArray(), sChars = s.toCharArray();
        int count = 0, l = 0, r = 0;
        for (char c : pChars) {
            int index = c - 'a';
            if (mark[index] == 0) count++;
            mark[index]++;
        }
        while (r < p.length()) {
            int index = sChars[r++] - 'a';
            if (mark[index] == 0) count++;
            else if (mark[index] == 1) count--;
            mark[index]--;
        }
        while (r < s.length()) {
            if (count == 0) ans.add(l);
            int indexL = sChars[l++] - 'a', indexR = sChars[r++] - 'a';
            mark[indexL]++;
            if (mark[indexL] == 0) count--;
            else if (mark[indexL] == 1) count++;
            mark[indexR]--;
            if (mark[indexR] == 0) count--;
            else if (mark[indexR] == -1) count++;
        }
        if (count == 0) ans.add(l);
        return ans;
    }

}
