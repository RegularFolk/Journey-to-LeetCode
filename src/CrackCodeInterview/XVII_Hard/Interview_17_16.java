package CrackCodeInterview.XVII_Hard;

public class Interview_17_16 {
    /*
     * 01背包
     *  简化版的LC_309
     * 分析好状态即可
     * */
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int len = nums.length;
        int[][] dp = new int[len][3];
        dp[0][0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]) + nums[i];
            dp[i][1] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
            dp[i][2] = dp[i - 1][1];
        }
        return Math.max(Math.max(dp[len - 1][0], dp[len - 1][1]), dp[len - 1][2]);
    }
}
