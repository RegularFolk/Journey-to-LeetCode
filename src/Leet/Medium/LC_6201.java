package Leet.Medium;

public class LC_6201 {
    /*
     * Î»ÔËËã
     * */
    public int[] findArray(int[] pref) {
        int[] ans = new int[pref.length];
        ans[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            ans[i] = getDigit(pref[i - 1], pref[i]);
        }
        return ans;
    }

    //  a ^ c = b ,Çóc
    private int getDigit(int a, int b) {
        int res = 0, count = 0;
        while (a > 0 || b > 0) {
            int cur;
            if ((b & 1) == 1) {
                cur = (a & 1) == 1 ? 0 : 1;
            } else {
                cur = (a & 1) == 1 ? 1 : 0;
            }
            cur <<= count++;
            a >>= 1;
            b >>= 1;
            res += cur;
        }
        return res;
    }
}
