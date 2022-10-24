package JzOffer.JzOffer_I;

import java.util.Arrays;

public class JzOffer_45 {
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Integer[] integers = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            integers[i] = nums[i];
        }
        Arrays.sort(integers, (n1, n2) -> (String.valueOf(n1) + n2).compareTo(String.valueOf(n2) + n1));
        StringBuilder ans = new StringBuilder();
        for (Integer integer : integers) {
            ans.append(integer);
        }
        return ans.toString();
    }
}
