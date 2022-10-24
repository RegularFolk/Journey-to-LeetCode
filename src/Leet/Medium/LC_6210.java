package Leet.Medium;

import org.junit.Test;

public class LC_6210 {
    /*
     * 削峰填谷,最终变成降序数组，效率太低
     * */
    public int minimizeArrayValue(int[] nums) {
        int curMax = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            curMax = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] > nums[i]) {
                    flag = true;
                    int sum = (nums[i] + nums[i + 1]) >> 1;
                    int carry = (nums[i] + nums[i + 1]) & 1;
                    nums[i] = sum + carry;
                    nums[i + 1] = sum;
                }
                curMax = Math.max(curMax, nums[i]);
            }
        }
        return curMax;
    }

    @Test
    public void x() {
        int i = minimizeArrayValue(new int[]{4, 7, 2, 2, 9, 19, 16, 0, 3, 15});
        System.out.println(i);
    }
}
