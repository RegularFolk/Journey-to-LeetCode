package Leet.Medium;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

public class LC_2280 {
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, Comparator.comparingInt(p -> p[0]));
        int ans, length = stockPrices.length;
        if (length >= 3) {
            ans = 1;
            for (int i = 1; i < length - 1; i++) {
                if (linkable(stockPrices[i - 1], stockPrices[i], stockPrices[i + 1])) {
                    ans++;
                }
            }
        } else {
            ans = length - 1;
        }
        return ans;
    }

    //使用bigDecimal是出于精度的考虑
    private boolean linkable(int[] stockPrice, int[] stockPrice1, int[] stockPrice2) {
        BigDecimal dx1 = new BigDecimal(String.valueOf(stockPrice[0] - stockPrice1[0])),
                dx2 = new BigDecimal(String.valueOf(stockPrice[0] - stockPrice2[0])),
                dy1 = new BigDecimal(String.valueOf(stockPrice[1] - stockPrice1[1])),
                dy2 = new BigDecimal(String.valueOf(stockPrice[1] - stockPrice2[1]));
        return !dx1.multiply(dy2).equals(dx2.multiply(dy1));
    }
}
