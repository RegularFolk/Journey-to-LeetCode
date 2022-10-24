package JzOffer.JzOffer_I;

/*
典型的双指针
*/
public class JzOffer_21 {

    public int[] exchange(int[] nums) {
        if (nums != null && nums.length >= 2) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                while (l < nums.length && (nums[l] & 1) == 1) { //左指针找一个偶数
                    l++;
                }
                while (r >= 0 && (nums[r] & 1) == 0) { //右指针找一个奇数
                    r--;
                }
                if (l < r) {
                    swap(nums, l, r);
                }
            }
        }
        return nums;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
