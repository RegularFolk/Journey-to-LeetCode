package LeetCode.Easy;

public class LC_674 {
    /*
     * 连续递增序列
     * dp[i] 为 下标 i 为结尾的最长连续递增序列
     * dp[i] = dp[i-1] + 1 or 1
     * */
    public int findLengthOfLCIS(int[] nums) {
        int max = 1, a = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                a++;
                max = Math.max(max, a);
            } else a = 1;
        }
        return max;
    }
}
