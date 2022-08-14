package JzOffer;

import java.util.Arrays;

public class JzOffer_17 {
    public int[] printNumbers(int n) {
        int max = 9;
        while (n-- > 1) {
            max = max * 10 + 9;
        }
        max = (int) Math.pow(10, n) - 1;
        int[] ans = new int[max];
        for (int i = 1; i <= max; i++) {
            ans[i - 1] = i;
        }
        return ans;
    }
}
