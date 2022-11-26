package JzOffer.JzOffer_II;


import java.util.HashMap;
import java.util.Map;

public class JzOfferII_011 {
    /*
     * ȡ�ɣ��������0����-1�����Ϊ0��������飬��ת��Ϊǰ׺����
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
