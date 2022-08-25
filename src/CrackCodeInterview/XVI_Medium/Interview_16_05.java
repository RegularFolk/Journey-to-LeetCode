package CrackCodeInterview.XVI_Medium;

public class Interview_16_05 {
    /*
     * 数有几个5的因数，再数有几个5^2的因数，以此类推
     * */
    public int trailingZeroes(int n) {
        if (n < 0) {
            return -1;
        }
        int ans = 0;
        for (long i = 5; n / i > 0; i *= 5) {
            ans += n / i;
        }
        return ans;
    }
}
