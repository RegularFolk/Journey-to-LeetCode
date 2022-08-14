package JzOffer;

public class JzOffer_16 {
    public double myPow(double x, int n) {
        if (x == 0) {
            throw new RuntimeException();
        }
        if (n == 0 || x == 1) {
            return 1d;
        }
        long b = n;
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }
        return power(x, b);
    }

    private double power(double x, long n) {
        double ans = 1;
        while (n > 0) { //递归会爆栈，转为迭代
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }

    private double power1(double x, long n) { //递归形式
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double res = power1(x, n >> 1);
        res *= res;
        if ((n & 1) == 1) {
            res *= x;
        }
        return res;
    }
}
