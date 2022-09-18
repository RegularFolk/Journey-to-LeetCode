package Medium;

import org.junit.Test;

import java.util.Arrays;

public class LC_6186 {
//    public int[] smallestSubarrays1(int[] nums) {
//        int max = nums[0], len = 1;
//        int[][] dp = new int[nums.length][2];
//        dp[0][0] = nums[0];
//        dp[0][1] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            int or = dp[]
//        }
//    }

    /*
     * ³¢ÊÔ±¬×§
     * 10^5 ÎÞÇé³¬Ê±
     * */
    public int[] smallestSubarrays2(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        for (int i = 0; i < nums.length; i++) {
            int cur = 0, max = 0;
            for (int j = i; j < nums.length; j++) {
                cur |= nums[j];
                if ((cur == max && j - i + 1 < ans[i]) || cur > max) {
                    ans[i] = j - i + 1;
                    max = cur;
                }
            }
        }
        return ans;
    }

    @Test
    public void s() {
        int[] ints = smallestSubarrays2(new int[]{0});
        String string = Arrays.toString(ints);
        System.out.println(string);
    }
}
