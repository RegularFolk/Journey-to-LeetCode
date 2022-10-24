package JzOffer.JzOffer_I;

public class JzOffer_53_2 {
    public int missingNumber(int[] nums) {  //利用二分查找第一个下标与值不对应的数
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] != mid) {
                if (mid == 0 || nums[mid - 1] == mid - 1) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left == nums.length) {
            return left;
        }
        throw new RuntimeException("???");
    }

}
