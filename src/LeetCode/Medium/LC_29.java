package LeetCode.Medium;

public class LC_29 {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -3));
    }

    public static int divide(int dividend, int divisor) {
        boolean flag = false;
        int ans = 0;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else if (divisor == 1) {
                return dividend;
            }
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend < 0 && divisor > 0) {
            flag = true;
            if (dividend == Integer.MIN_VALUE) {
                divisor = -divisor;
            } else {
                dividend = -dividend;
            }
        } else if (dividend > 0 && divisor < 0) {
            flag = true;
            divisor = -divisor;
        }
        if (divisor != 1) {
            if (dividend > 0 && divisor > 0) {
                while (dividend >= divisor) {
                    dividend -= divisor;
                    ans++;
                }
            } else if (dividend < 0 && divisor < 0) {
                while (dividend <= divisor) {
                    dividend -= divisor;
                    ans++;
                }
            }
        } else {
            ans = dividend;
        }
        if (flag) {
            return -ans;
        } else {
            return ans;
        }
    }
}
