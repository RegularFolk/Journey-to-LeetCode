package JzOffer.JzOffer_II;


import java.util.HashMap;
import java.util.Map;

public class JzOfferII_010 {
    /*
     * ���ڸ�ֵ����������������˫ָ��
     * ���������飬ʹ������ǰ׺��
     * */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//��һ��0��ʾ�պõ�ǰǰ׺��Ϊk
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
