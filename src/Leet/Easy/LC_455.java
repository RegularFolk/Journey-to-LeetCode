package Leet.Easy;

import java.util.Arrays;

public class LC_455 {
    /*
     * Ì°ÐÄ+ÅÅÐò
     * */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cursor1 = 0, cursor2 = 0, count = 0;
        while (cursor1 < g.length && cursor2 < s.length) {
            if (s[cursor2] >= g[cursor1]) {
                count++;
                cursor1++;
            }
            cursor2++;
        }
        return count;
    }
}
