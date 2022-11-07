package LeetCode.Easy;

import java.util.ArrayList;

public class LC_349 {
    /*
     * 用数组做散列表
     * */
    private final int[] map = new int[1001];

    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i : nums1) {
            map[i] = 1;
        }
        for (int i : nums2) {
            if (map[i] != 0) {
                ans.add(i);
                map[i]--;
            }
        }
        return ans.stream().mapToInt(x -> x).toArray();
    }
}
