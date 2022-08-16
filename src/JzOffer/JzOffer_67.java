package JzOffer;

import org.junit.Test;

public class JzOffer_67 {
    @Test
    public void t() {
        int i = strToInt("  ");
        System.out.println("i = " + i);
    }

    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int left = 0;
        while (left < str.length() && str.charAt(left) == ' ') {
            left++;
        }
        if (left == str.length() || str.charAt(left) != '-' && str.charAt(left) != '+' && (str.charAt(left) < '0' || str.charAt(left) > '9')) {
            return 0;
        }
        int right = left + 1;
        while (right < str.length() && str.charAt(right) >= '0' && str.charAt(right) <= '9') {
            right++;
        }
        if (str.charAt(right - 1) < '0' || str.charAt(right - 1) > '9') {
            return 0;
        }
        double ans = 0;
        boolean neg = false;
        while (left < right) {
            char c = str.charAt(left);
            if (c == '-') {
                neg = true;
            } else if (c != '+') {
                ans = ans * 10 + c - '0';
            }
            left++;
        }
        ans *= neg ? -1 : 1;
        return neg ? (int) Math.max(Integer.MIN_VALUE, ans) : (int) Math.min(Integer.MAX_VALUE, ans);
    }

}

