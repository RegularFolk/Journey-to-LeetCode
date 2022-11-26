package JzOffer.JzOffer_II;

public class JzOfferII_012 {
    public int pivotIndex(int[] nums) {
        int sum = 0, curSum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (curSum << 1 == sum - nums[i]) return i;
            curSum += nums[i];
        }
        return -1;
    }
}
