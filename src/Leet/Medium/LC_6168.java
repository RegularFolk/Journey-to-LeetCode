package Leet.Medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LC_6168 {
    /*
     * 排列数学题
     * 利用组合公式取余了之后再用除法会得到错误答案
     * */
    public int numberOfWays1(int startPos, int endPos, int k) {
        int dis = Math.abs(endPos - startPos);
        if (((k - dis) & 1) == 1) return 0;
        int a = compute(k), b = compute((k - dis) >> 1), c = compute((k + dis) >> 1);
        return (a / ((b * c) % 1000000007)) % 1000000007;
    }

    private int compute(int num) {
        long ans = 1, count = 2;
        while (count <= num) {
            ans = (ans * count) % 1000000007;
            count++;
        }
        return (int) ans;
    }

    /*
     * 使用记忆化递归
     * */
    private final Map<Integer, Long> map = new HashMap<>();
    private int e;

    public int numberOfWays2(int startPos, int endPos, int k) {
        e = endPos;
        return (int) dfs(startPos, k);
    }

    private long dfs(int start, int step) {
        if (Math.abs(e - start) > step) return 0;//已无法抵达
        if (step == 0) return 1;
        int key = start * 1000 + step;
        Long mapValue = map.getOrDefault(key, -1L);
        if (mapValue != -1) return mapValue;
        long value = (dfs(start + 1, step - 1) + dfs(start - 1, step - 1)) % 1000000007;
        map.put(key, value);
        return value;
    }

    @Test
    public void x() {
        int i = numberOfWays1(264, 198, 68);
        System.out.println(i);
    }
}
