package Leet.Easy;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LC_202 {
    /*
     * 失败的标记是出现了之前出现过的sum
     * 用一个set记录
     * */
    private final Set<Integer> set = new HashSet<>();
    private final int[] square = new int[]{0, 1, 4, 9, 16, 25, 36, 49, 64, 81};

    public boolean isHappy(int n) {
        if (n == 1) return true;
        int sum = 0;
        while (n > 0) {
            sum += square[n % 10];
            n /= 10;
        }
        if (set.contains(sum)) return false;
        set.add(sum);
        return isHappy(sum);
    }

    @Test
    public void s() {
        boolean happy = isHappy(2);
        System.out.println(happy);
    }
}
