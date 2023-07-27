package LeetCode.Medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC_128 {
    /*
     * ��ɨ��һ�ν�����ϣ��֮����ڹ�ϣ�����
     * ÿ������һ��������ݹ����С���������һ�߲���һ����������ظ����㣬
     * ͬʱ���µ�ǰ��ǰ�����ĸ���
     * */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.getOrDefault(num, 0) == 0) {
                map.put(num, 1);
            }
        }
        Set<Integer> set = map.keySet();
        for (Integer e : set) {
            int v = map.getOrDefault(e, 0);
            if (v > 0) {
                v = v + analyse(map, e - 1);
                map.put(e, v);
                ans = Math.max(ans, v);
            }
        }
        return ans;
    }

    private int analyse(Map<Integer, Integer> map, Integer key) {
        Integer value = map.getOrDefault(key, 0);
        if (value == 0) {
            return 0;
        } else {
            int ans = value + analyse(map, key - 1);
            map.put(key, 0);//��0�����ظ�����
            return ans;
        }
    }

    //@Test
    public void s() {
        int i = longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(i);
    }
}

class redo_128 {
    /*
     * ��ϣ��
     * */
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        // key:ĩβ��ֵ  value:�����
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            set.add(num);
        }
        for (Integer num : set) {
            int cnt = anal(num, set, cntMap);
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    private static int anal(Integer num, Set<Integer> set, Map<Integer, Integer> cntMap) {
        if (!set.contains(num)) return 0;
        int cnt = 1;
        Integer mapVal = cntMap.getOrDefault(num, -1);
        if (mapVal != -1) return mapVal;
        cnt += anal(num - 1, set, cntMap);
        cntMap.put(num, cnt);
        return cnt;
    }

    public static void main(String[] args) {
        int i = longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(i);
    }

}
