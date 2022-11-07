package LeetCode.Easy;

import java.util.Arrays;

public class LC_283 {
    /*
     * �Ӻ���ǰ����ð��
     * */
    public void moveZeroes1(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length && nums[j] != 0; j++) {
                    int num = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = num;
                }
            }
        }
    }

    /*
     * �Ż���������
     * */
    public void moveZeroes2(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                    if (j == nums.length - 1 || nums[j + 1] == 0) {
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }

    /*
     * ˫ָ��
     * */
    public void moveZeroes3(int[] nums) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] != 0) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        Arrays.fill(nums, l, r, 0);
    }
}
