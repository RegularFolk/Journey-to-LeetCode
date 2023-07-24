package LeetCode.Medium;

public class LC_1911 {
    public long maxAlternatingSum(int[] nums) {
        int len = nums.length;
        // dp1表示以+nums[i]结尾的最大，总共有奇数个
        // dp2表示以-nums[i]结尾的最大，总共有偶数个
        long dp1 = nums[0];
        long dp2 = 0;
        for (int i = 1; i < len; i++) {
            dp1 = Math.max(dp1, dp2 + nums[i]);
            dp2 = Math.max(dp2, dp1 - nums[i]);
        }
        return Math.max(dp1, dp2);
    }
}
