package Leet.Medium;

import java.util.Arrays;

public class LC_462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, tar = nums[nums.length / 2];
        for (int num : nums) {
            ans += Math.abs(num - tar);
        }
        return ans;
    }
}
