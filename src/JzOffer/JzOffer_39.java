package JzOffer;

public class JzOffer_39 {
    public int majorityElement(int[] nums) { //根据数组的特点求解（摩尔投票法）
        int ans = nums[0], count = 0;
        for (int num : nums) {
            if (count == 0) {
                ans = num;
                count++;
            } else {
                count += ans == num ? 1 : -1;
            }
        }
        return ans;
    }

}
