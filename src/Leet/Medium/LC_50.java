package Leet.Medium;

public class LC_50 {
    /*
     * ����ָ������ż�Դ���
     * */
    public double myPow(double x, int n) {
        return pow(x, n);

    }

    private double pow(double x, long n) {
        if (n < 0) {
            x = 1 / x;
            n = -1 * n;
        }
        if (n == 0) return 1;
        else if (n == 1) return x;
        else if ((n & 1) == 1) return x * pow(x, n - 1);
        else {
            double v = pow(x, n >> 1);
            return v * v;
        }
    }
}
