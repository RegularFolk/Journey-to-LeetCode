package LeetCode.Medium;

import org.junit.Test;

import java.util.Arrays;

public class LC_16 {
    public int threeSumClosest(int[] nums, int target) {
        int dis = Integer.MAX_VALUE, ans = -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if (sum == target) return sum;
                int abs = Math.abs(target - sum);
                if (abs < dis) {
                    ans = sum;
                    dis = abs;
                }
                if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }
}
