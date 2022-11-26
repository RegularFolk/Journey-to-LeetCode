package JzOffer.JzOffer_II;

public class JzOfferII_009 {
    /*
    * Ë«Ö¸Õë
    *   ÀàËÆÓÚ008
    * */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int ans = 0, sum = 1, l = 0, r = 0;
        while (r < nums.length) {
            sum *= nums[r++];
            while (sum >= k) sum /= nums[l++];
            ans += r - l;
        }
        return ans;
    }
}
