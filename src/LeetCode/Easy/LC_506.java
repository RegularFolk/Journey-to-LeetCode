package LeetCode.Easy;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class LC_506 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
    }

    public static String[] findRelativeRanks(int[] score) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        String[] ans = new String[score.length];
        int count = score.length;
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }
        Map.Entry<Integer, Integer> cursor = map.firstEntry();
        while (cursor != null) {
            if (count == 1) {
                ans[cursor.getValue()] = "Gold Medal";
            } else if (count == 2) {
                ans[cursor.getValue()] = "Silver Medal";
            } else if (count == 3) {
                ans[cursor.getValue()] = "Bronze Medal";
            } else {
                ans[cursor.getValue()] = Integer.toString(count);
            }
            cursor = map.higherEntry(cursor.getKey());
            count--;
        }
        return ans;
    }
}
