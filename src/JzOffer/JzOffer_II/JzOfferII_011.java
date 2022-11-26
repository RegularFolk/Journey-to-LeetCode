package JzOffer.JzOffer_II;


import java.util.HashMap;
import java.util.Map;

public class JzOfferII_011 {
    /*
     * 取巧，将数组的0换成-1，求和为0的最长子数组，再转化为前缀问题
     * */
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) if (nums[i] == 0) nums[i] = -1;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int tar = sum;
            if (sum == 0) ans = i + 1;
            else {
                int left = map.getOrDefault(tar, -1);
                if (left != -1) ans = Math.max(ans, i - left);
            }
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return ans;
    }

}
