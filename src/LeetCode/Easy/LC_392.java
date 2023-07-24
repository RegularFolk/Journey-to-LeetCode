package LeetCode.Easy;

public class LC_392 {
    /*
     * ¼òµ¥µÄË«Ö¸Õë
     * */
    public boolean isSubsequence(String s, String t) {
        int c1 = 0, c2 = 0;
        char[] sc = s.toCharArray(), tc = t.toCharArray();
        while (c1 < sc.length) {
            while (c2 < tc.length) {
                if (tc[c2] == sc[c1]) {
                    break;
                } else {
                    c2++;
                }
            }
            if (c2 < tc.length && tc[c2] == sc[c1]) {
                c1++;
                c2++;
            } else {
                return false;
            }
        }
        return true;
    }
}
