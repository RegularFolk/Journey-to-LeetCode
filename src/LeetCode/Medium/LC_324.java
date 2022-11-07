package LeetCode.Medium;

import java.util.Arrays;

public class LC_324 {
    public void wiggleSort(int[] nums) { //排序之后拆两半
        Arrays.sort(nums);
        if (nums.length > 2) {
            int cur1 = 0, cur2 = 0, len2 = nums.length / 2;
            int[] left = Arrays.copyOfRange(nums, 0, nums.length - len2), right = Arrays.copyOfRange(nums, nums.length - len2, nums.length);
            boolean flag = true;
            for (int j = 0; j < nums.length; j++) { //需要从后往前填，不会出错
                if (flag) {
                    nums[j] = left[left.length - cur1++ - 1];
                } else {
                    nums[j] = right[right.length - cur2++ - 1];
                }
                flag = !flag;
            }
        }
    }
}
