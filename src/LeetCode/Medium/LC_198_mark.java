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

    /*
     * 动态规划
     * dp[i] 表示偷到 i 户时最多的钱
     * 所以 dp[i] = max(dp[i-1], dp[i-2] + val[i])
     * 前者是不偷当前这家，后者是偷当前这家
     * 只和前两个值有关，可以使用滚动数组优化空间复杂度
     * 注意初始化
     *
     * 有一个容易产生疑惑的点，对于dp[i] ，可能产生最大值时下标为i是不取到的
     * 那么对于dp[i+1]，不是就可以选择dp[i] + nums[i+1]吗？
     * 对于这种情况，dp[i] == dp[i-1],上述的递推公式是兼容的
     * */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int a = nums[0], b = Math.max(nums[0], nums[1]), c = nums[2];
        for (int i = 2; i < nums.length; i++) {
            c = Math.max(a + nums[i], b);
            a = b;
            b = c;
        }
        return c;
    }
}
