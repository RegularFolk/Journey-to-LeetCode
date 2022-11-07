package LeetCode.Easy;

import org.junit.Test;

public class LC_6208 {
    public int countTime(String time) {
        char[] chars = time.toCharArray();
        int ans = 0;
        if (chars[4] == '?') ans += 10;
        if (chars[3] == '?') ans = chars[4] == '?' ? 60 : 6;
        if (chars[0] == '?' && chars[1] == '?') {
            ans = ans == 0 ? 24 : ans * 24;
        } else if (chars[0] == '?') {
            if (chars[1] < '4') ans = ans == 0 ? 3 : ans * 3;
            else ans = ans == 0 ? 2 : ans * 2;
        } else if (chars[1] == '?') {
            if (chars[0] == '2') ans = ans == 0 ? 4 : ans * 4;
            else ans = ans == 0 ? 10 : ans * 10;
        }
        return Math.max(ans, 1);
    }

    @Test
    public void s() {
        int i = countTime("2?:??");
        System.out.println(i);
    }
}
