package JzOffer.JzOffer_II;

import java.util.Random;

public class JzOfferII_071 {
    /*
     * 前缀和+二分
     * */
    static class Solution {
        int[] pre;
        int sum;

        public Solution(int[] w) {
            pre = new int[w.length];
            pre[0] = w[0];
            sum = w[0];
            for (int i = 1; i < w.length; i++) {
                pre[i] = pre[i - 1] + w[i];
                sum += w[i];
            }
        }

        public int pickIndex() {
            int r = new Random().nextInt(sum) + 1;
            int left = 0, right = pre.length - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (pre[mid] < r) left = mid + 1;
                else right = mid - 1;
            }
            return left;
        }
    }

}
