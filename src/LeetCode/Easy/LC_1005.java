package LeetCode.Easy;

import java.util.Arrays;

public class LC_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int mark1 = 0;
        int ans = 0;
        for (int i = 0; i < nums.length && nums[i] <= 0 && k > 0; i++, k--) {
            nums[i] *= -1;
            mark1 = i;
        }
        if (k > 0 && k % 2 != 0) {
            nums[mark1 < nums.length - 1 ? nums[mark1] <= nums[mark1 + 1] ? mark1 : mark1 + 1 : mark1] *= -1;
        }
        for (int n : nums) {
            ans += n;
        }
        return ans;
    }
}
