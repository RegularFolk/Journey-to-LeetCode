package Leet.Easy;

public class LC_461 {
    /*
     * Î»ÔËËã Òì»ò
     * */
    public int hammingDistance(int x, int y) {
        int ans = 0, xor = x ^ y;
        while (xor > 0) {
            ans += xor & 1;
            xor >>= 1;
        }
        return ans;
    }
}
