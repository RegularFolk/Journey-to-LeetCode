package LeetCode.Medium;

public class LC_795 {
    /*
    * 最大元素满足大于等于L小于等于R的子数组个数 = 最大元素小于等于R的子数组个数 - 最大元素小于L的子数组个数
    * */
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    private int count(int[] nums, int tar) {
        int ans = 0, count = 0;
        for (int num : nums) {
            if (num <= tar) ans += ++count;
            else count = 0;
        }
        return ans;
    }
}
