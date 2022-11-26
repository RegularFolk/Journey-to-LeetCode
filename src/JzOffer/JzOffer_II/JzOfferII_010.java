package JzOffer.JzOffer_II;


import java.util.HashMap;
import java.util.Map;

public class JzOfferII_010 {
    /*
     * 存在负值，不可以用伸缩的双指针
     * 连续子数组，使用朴素前缀和
     * */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//加一个0表示刚好当前前缀和为k
        int sum = 0, ans = 0;
        for (int num : nums) {
            sum += num;
            int tar = sum - k;
            ans += map.getOrDefault(tar, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

}
