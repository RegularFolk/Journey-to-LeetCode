package CrackCodeInterview.X_Sorting_Searching;

import org.junit.Test;

import java.util.Arrays;

public class Interview_10_11 {
    /*
     * 排序后跳着交换
     * */
    public void wiggleSort1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
                i++;
            }
        }
    }

    /*
     * 不进行排序，将时间复杂度优化到n
     * 找出每三个数组中的谷，交换即可
     * */
    public void wiggleSort2(int[] nums) {
        for (int i = 1; i < nums.length; i += 2) {
            int valley = findValley(nums, i - 1, i, i + 1);
            swap(nums, i, valley);
        }
    }

    private int findValley(int[] nums, int left, int mid, int right) {
        if (right > nums.length - 1) {
            return nums[left] >= nums[mid] ? mid : left;
        } else {
            if (nums[left] >= nums[mid] && nums[right] >= nums[mid]) {
                return mid;
            } else if (nums[left] <= nums[mid] && nums[left] <= nums[right]) {
                return left;
            } else {
                return right;
            }
        }
    }

    private void swap(int[] nums, int i, int valley) {
        if (i != valley) {
            int temp = nums[i];
            nums[i] = nums[valley];
            nums[valley] = temp;
        }
    }

    @Test
    public void s() {
        int[] nums = {3, 5, 2, 1, 6, 4};
        wiggleSort2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
