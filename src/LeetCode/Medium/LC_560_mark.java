package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class LC_560_mark {
    /*
     * ��������
     * �޷��û������ڣ���Ϊ�м�������С���㣬�޷�������ָ���ƻ�����ָ����
     * �ù�ϣ���¼ǰ׺��(��0��ÿ���ڵ���ۼӺ�)
     *
     *             ������sum(��0�ۼ������±꣬����k)
     *  |____________|_______________________________________|
     *    required                    K
     *     ��map��
     *
     * */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ans = 0;
        for (int num : nums) {
            sum += num;
            int required = sum - k;
            Integer mapValue = map.getOrDefault(required, 0);
            ans += mapValue;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
