package LeetCode.Easy;

public class LC_1822 {
    public int arraySign(int[] nums) {
        boolean isNegative = false;
        for (int num : nums) {
            if (num == 0) return 0;
            else if (num < 0) isNegative = !isNegative;
        }
        return isNegative ? -1 : 1;
    }
}
