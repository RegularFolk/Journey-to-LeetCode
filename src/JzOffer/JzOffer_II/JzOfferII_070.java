package JzOffer.JzOffer_II;

public class JzOfferII_070 {
    /*
     * 二分查找的应用题
     *
     * */
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int ans = (left + right) >> 1;
            if ((ans ^ 1) < nums.length && nums[ans] == nums[ans ^ 1]) left = ans + 1;
            else right = ans - 1;
        }
        return nums[left];
    }
}
