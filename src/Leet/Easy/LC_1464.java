package Leet.Easy;

public class LC_1464 {
    public int maxProduct(int[] nums) {
        int max1 = Math.max(nums[0], nums[1]), max2 = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max2) {
                if (nums[i] > max1) {
                    max2 = max1;
                    max1 = nums[i];
                } else {
                    max2 = nums[i];
                }
            }
        }
        return (max1 - 1) * (max2 - 1);
    }
}
