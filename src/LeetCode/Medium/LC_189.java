package LeetCode.Medium;

import org.junit.Test;

import java.util.Arrays;

public class LC_189 {
    /*
     * 想象一个轮转
     * 这种解法存在数学上的缺陷
     * */
    public void rotate1(int[] nums, int k) {
        int realK = k % nums.length;
        if (realK == 0) return;
        int next = realK, mark = nums[0];
        while (true) {
            int temp = nums[next];
            nums[next] = mark;
            mark = temp;
            if (next == 0) break;
            next = (next + realK) % nums.length;
        }

    }

    /*
     * 更加巧妙的一种解法
     * 以k为分界线，先整体翻转，再翻转前一半，再翻转后一半
     * 比较难临场想到
     * */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        int lc = l, rc = r;
        while (lc < rc) {
            int temp = nums[lc];
            nums[lc] = nums[rc];
            nums[rc] = temp;
            lc++;
            rc--;
        }
    }

    @Test
    public void t() {
        int[] nums = {1, 2};
        rotate2(nums, 1);
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
    }
}
