package LeetCode.Medium;

import org.junit.Test;

import java.util.Arrays;

public class LC_189 {
    /*
     * ����һ����ת
     * ���ֽⷨ������ѧ�ϵ�ȱ��
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
     * ���������һ�ֽⷨ
     * ��kΪ�ֽ��ߣ������巭ת���ٷ�תǰһ�룬�ٷ�ת��һ��
     * �Ƚ����ٳ��뵽
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
