package JzOffer.JzOffer_II;

public class JzOfferII_008 {
    /*
     * 双指针,一头拓展一头缩短
     * */
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, l = 0, r = 0, min = Integer.MAX_VALUE;
        while (r < nums.length) {
            while (sum < target && r < nums.length) {
                sum += nums[r++];
            }
            while (sum >= target && l < r) {
                min = Math.min(min, r - l);
                sum -= nums[l++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
