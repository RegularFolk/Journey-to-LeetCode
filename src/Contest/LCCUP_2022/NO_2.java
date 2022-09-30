package Contest.LCCUP_2022;

import org.junit.Test;

import java.util.*;

public class NO_2 {
    /*
     * 找一个点，所有点都指着它，它不指着任何点
     * 散列表
     * 代码不够优雅
     * */
    public int transportationHub(int[][] path) {
        Map<Integer, Set<Integer>> map = new HashMap<>();//记录路径
        Set<Integer> all = new HashSet<>();//记录全部点
        ArrayList<Integer> candidates = new ArrayList<>();
        for (int[] ints : path) {
            Set<Integer> list = map.getOrDefault(ints[0], null);
            if (list == null) list = new HashSet<>();
            list.add(ints[1]);
            map.put(ints[0], list);
            all.add(ints[0]);
            all.add(ints[1]);
        }
        for (int[] ints : path) {
            if (!map.containsKey(ints[1])) candidates.add(ints[1]);
        }
        int ans = -1;
        Set<Map.Entry<Integer, Set<Integer>>> entries = map.entrySet();
        if (entries.size() != all.size() - 1) return ans;
        for (Integer candidate : candidates) {
            boolean flag = true;
            for (Map.Entry<Integer, Set<Integer>> entry : entries) {
                if (!entry.getValue().contains(candidate)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = candidate;
                break;
            }
        }
        return ans;
    }

    @Test
    public void x() {
        int i = transportationHub(new int[][]{{0, 1}, {0, 3}, {1, 3}, {2, 0}, {2, 3}});
        System.out.println("i = " + i);
    }
}
