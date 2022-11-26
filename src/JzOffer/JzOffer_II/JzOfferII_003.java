package JzOffer.JzOffer_II;

public class JzOfferII_003 {
    /*
     * 位运算+DP
     * 如果i是偶数，i的1数量与1/2相同;否则为i/2+1
     * */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) ans[i] = ans[i >> 1] + (i & 1);
        return ans;
    }
}
