package Leet.Medium;

public class LC_926 {
    public int minFlipsMonoIncr(String s) { //利用前后缀，找分界点，计算分界点之前有几个1，之后有几个0
        char[] chars = s.toCharArray();
        int len = s.length(), l = 0, r = 0;
        char mark = chars[0];
        for (int i = 1; i < len; i++) {
            if (chars[i] == '0') {
                r++;
            }
        }
        int ans = r;
        for (int i = 1; i < len; i++) {
            if (mark == '1') {
                l++;
            }
            if (chars[i] == '0') {
                r--;
            }
            mark = chars[i];
            ans = Math.min(ans, l + r);
        }
        return ans;
    }
}
