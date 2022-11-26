package LeetCode.Medium;

public class LC_581 {
    /*
     * 贪心
     * 找出中间一段最短的无序子序列，说明左右两端都是有序
     * 对于左端，每遍历的一个数都是当前遍历的最大值
     * 对于右端，每遍历的一个数都是当前遍历的最小值
     * 不满足上述两个条件的即为答案
     * */
    public int findUnsortedSubarray(int[] nums) {
        int curMax = nums[0], curMin = nums[nums.length - 1];
        int left = 0, right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < curMax) right = i;
            else curMax = nums[i];
            if (nums[nums.length - i - 1] > curMin) left = nums.length - i - 1;
            else curMin = nums[nums.length - i - 1];
        }
        return right - left + 1;
    }
}
