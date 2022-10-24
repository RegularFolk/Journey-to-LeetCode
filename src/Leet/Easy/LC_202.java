package Leet.Easy;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class LC_202 {
    /*
     * ʧ�ܵı���ǳ�����֮ǰ���ֹ���sum
     * ��һ��set��¼
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
