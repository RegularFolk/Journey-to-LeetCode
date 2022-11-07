package LeetCode.Medium;

public class LC_494 {
    /*
     * 数组长度小于等于20，一眼回溯
     * 巨慢无比，时间复杂度2^n
     * */
    private int ans = 0;

    public int findTargetSumWays1(int[] nums, int target) {
        roll(nums, target, 0, 0);
        return ans;
    }

    private void roll(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) ans++;
            return;
        }
        roll(nums, target, index + 1, sum + nums[index]);
        roll(nums, target, index + 1, sum - nums[index]);
    }

    /*
     * 动态规划，背包问题
     * */
    public int findTargetSumWays2(int[] nums, int target) {
        return 0;
    }
}
