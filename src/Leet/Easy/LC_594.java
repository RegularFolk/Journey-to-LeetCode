package Leet.Easy;

import java.util.Arrays;
import java.util.HashMap;

public class LC_594 {
    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1, 2, 2, 1}));
    }

    public static int findLHS(int[] numbs) {  //法一利用排序
        Arrays.sort(numbs);
        int quickCursor;
        int slowCursor = 0;
        int ans = 0;
        for (quickCursor = 0; quickCursor < numbs.length; quickCursor++) {
            while (numbs[quickCursor] - numbs[slowCursor] > 1) {
                slowCursor++;
            }
            if (numbs[quickCursor] - numbs[slowCursor] == 1) {
                ans = Math.max(ans, quickCursor - slowCursor + 1);
            }
        }
        return ans;
    }

    public static int findLHS2(int[] numbs) {  //法二利用哈希表
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int ans = 0;
        for (int num : numbs) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for (int key : hashMap.keySet()) {
            if (hashMap.containsKey(key + 1)) {
                ans = Math.max(hashMap.get(key) + hashMap.get(key + 1), ans);
            }
        }
        return ans;
    }
}
