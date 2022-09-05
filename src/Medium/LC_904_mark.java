package Medium;

import org.junit.Test;

public class LC_904_mark {
    /*
     * 求连续的最长的由两个数组成的连续子数组
     * 滑动窗口
     * 难点在于处理慢指针
     * 慢指针移动要从快指针开始往前找
     * */
    public int totalFruit(int[] fruits) {
        int max = -1, basket1 = fruits[0], basket2 = -1, l = 0, r = 0;
        while (r < fruits.length) {
            if (fruits[r] == basket1 || fruits[r] == basket2 || basket2 == -1) {
                if (basket2 == -1 && fruits[r] != basket1) {
                    basket2 = fruits[r];
                }
                max = Math.max(max, r - l + 1);
                r++;
            } else {
                l = r - 1;
                while (l > 0 && fruits[l - 1] == fruits[l]) l--;
                if (fruits[l] == fruits[r]) {
                    basket1 = fruits[l];
                    basket2 = -1;
                } else {
                    basket1 = fruits[l];
                    basket2 = fruits[r];
                }
            }
        }
        return max;
    }

    @Test
    public void x() {
        int i = totalFruit(new int[]{0, 0, 1, 1});
        System.out.println(i);
    }
}
