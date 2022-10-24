package JzOffer.JzOffer_I;

public class JzOffer_10 {
    public int fib(int n) {
        int ans = 0, a0 = 0, a1 = 1;
        if (n < 2) {
            return n == 0 ? 0 : 1;
        }
        for (int i = 2; i <= n; i++) {
            ans = (a0 + a1) % 1000000007;
            a0 = a1;
            a1 = ans;
        }
        return ans;
    }
}
