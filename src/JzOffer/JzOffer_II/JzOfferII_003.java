package JzOffer.JzOffer_II;

public class JzOfferII_003 {
    /*
     * λ����+DP
     * ���i��ż����i��1������1/2��ͬ;����Ϊi/2+1
     * */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) ans[i] = ans[i >> 1] + (i & 1);
        return ans;
    }
}
