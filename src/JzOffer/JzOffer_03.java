package JzOffer;

public class JzOffer_03 {
    public int findRepeatNumber(int[] nums) { //原地哈希
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if (nums[i] < 0) {
                index = nums[i] * (-1) - 1;
            }
            if (nums[index] < 0) {
                return index;
            } else {
                nums[index] = nums[index] * (-1) - 1;
            }
        }
        throw new RuntimeException();
    }
}
