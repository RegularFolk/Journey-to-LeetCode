package LeetCode.Medium;

public class LC_213_mark {
    /*
     * 做两组dp，一组取第一个，一组不取第一个
     * 将原数组分成两个分析，一个从0~n-1，一个从1~n
     * */
    public int rob(int[] nums) {
        if (nums.length < 2) return nums[0];
        int max1 = getMax(nums, 0, nums.length - 2);
        int max2 = getMax(nums, 1, nums.length - 1);
        return Math.max(max1, max2);
    }

    private int getMax(int[] nums, int left, int right) {
        if (right <= left + 1) return Math.max(nums[left], nums[right]);
        int[] dp = new int[nums.length];
        dp[left] = nums[left];
        dp[left + 1] = Math.max(nums[left], nums[left + 1]);
        for (int i = left + 2; i <= right; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[right];
    }
}

class LC_213_redo {
    /*
     * 偷两遍
     * 第一遍舍弃第一个
     * 第二遍舍弃最后一个
     * 把环给断开
     * */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int ans1 = rob(nums, 0, nums.length - 2);
        int ans2 = rob(nums, 1, nums.length - 1);
        return Math.max(ans1, ans2);
    }

    private int rob(int[] nums, int l, int r) {
        int[] dp = new int[nums.length];
        dp[l] = nums[l];
        dp[l + 1] = Math.max(nums[l], nums[l + 1]);
        for (int i = l + 2; i <= r; i++) {
            dp[i] = Math.max((nums[i] + dp[i - 2]), dp[i - 1]);
        }
        return dp[r];
    }
}
