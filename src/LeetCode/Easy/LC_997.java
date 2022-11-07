package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class LC_997 {
    public int findJudge(int n, int[][] trust) {
        if (n == 1) {
            return 1;
        }
        Map<Integer, Integer> record = new HashMap<>();
        int ans = -1;
        for (int[] nums : trust) {
            if (nums[0] == ans) {  //如果一个人被判断为法官之后又相信别人
                return -1;
            }
            record.put(nums[0], -1);
            int get = record.getOrDefault(nums[1], 0);
            if (get != -1) {
                record.put(nums[1], ++get);
                if (get == n - 1) {
                    ans = nums[1];
                }
            }
        }
        return ans;
    }

    public int findJudge2(int n, int[][] trust) {
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        for (int[] nums : trust) {
            in[nums[1]]++;
            out[nums[0]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
