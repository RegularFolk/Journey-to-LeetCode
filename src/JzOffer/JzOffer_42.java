package JzOffer;

public class JzOffer_42 {
    public int maxSubArray(int[] nums) {  //贪心算法，实际上就是dp
        int lastMax = nums[0], candidate = 0;
        for (int num : nums) {
            candidate += num;
            lastMax = Math.max(candidate, lastMax);
            if (candidate < 0) {
                candidate = 0;
            }
        }
        return lastMax;
    }

}
