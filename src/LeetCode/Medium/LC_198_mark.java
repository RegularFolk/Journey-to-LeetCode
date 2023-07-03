package LeetCode.Medium;

public class LC_198_mark {
    /*
     * 动态规划
     * 时间复杂度n^2
     * dp[i]表示以nums[i]结尾的最大值
     * */
    public int rob(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 2; j >= 0; j--) {
                dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] += nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /*
     * 优化递推方程,对每一间屋子，有偷或者不偷两种状态
     * dp[i] = max(dp[i]+dp[i-2],dp[i-1])
     * 还可以优化空间，只需保留dp[i-1]和dp[i-2]
     * */
    public int rob1(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}

class LC_198_redo {

    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i] + dp[i - 1][0];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}