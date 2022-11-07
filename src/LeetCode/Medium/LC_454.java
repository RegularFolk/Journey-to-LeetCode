package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class LC_454 {
    /*
     * �ù�ϣ��洢nums1��nums2��ӵĺͳ��ֵĴ���
     * �ٶ�nums3��nums4��������
     * С����
     * ���ĸ�����ֳ���������ʱ�临�Ӷȴ�n^4������2n^2
     * */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Long, Integer> map = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                map.put((long) (n1 + n2), map.getOrDefault((long) (n1 + n2), 0) + 1);
            }
        }
        int ans = 0;
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                ans += map.getOrDefault((long) ((n3 + n4) * -1), 0);
            }
        }
        return ans;
    }
}
