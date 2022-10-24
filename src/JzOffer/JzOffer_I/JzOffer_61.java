package JzOffer.JzOffer_I;

import java.util.Arrays;

public class JzOffer_61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        for (int num : nums) {
            if (num == 0) {
                zero++;
            }
        }
        for (int i = zero; i < 4; i++) {
            zero -= nums[i + 1] - nums[i] - 1;
            if (nums[i] == nums[i + 1] || zero < 0) {
                return false;
            }
        }
        return true;
    }
}
