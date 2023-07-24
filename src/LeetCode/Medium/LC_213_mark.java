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
     * 打家劫舍一（LC_198）的改进版
     * 拆开算两次，一次取头不取尾，一次取尾不取头
     * */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(help(nums, 0, nums.length - 1), help(nums, 1, nums.length));
    }

    private int help(int[] nums, int l, int r) {
        int[] cp = new int[r - l];
        System.arraycopy(nums, l, cp, 0, cp.length);
        if (cp.length == 2) return Math.max(cp[0], cp[1]);
        if (cp.length == 1) return cp[0];
        int a = cp[0], b = Math.max(cp[0], cp[1]), c = -1;
        for (int i = 2; i < cp.length; i++) {
            c = Math.max(a + cp[i], b);
            a = b;
            b = c;
        }
        return c;
    }
}
