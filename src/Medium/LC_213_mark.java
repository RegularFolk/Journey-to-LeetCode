package Medium;

public class LC_213_mark {
    /*
     * ������dp��һ��ȡ��һ����һ�鲻ȡ��һ��
     * ��ԭ����ֳ�����������һ����0~n-1��һ����1~n
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
