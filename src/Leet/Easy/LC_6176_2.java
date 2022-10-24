package Leet.Easy;

import org.junit.Test;

import java.util.Arrays;

public class LC_6176_2 {
    /*
     * ÅÅÐò+Ë«Ö¸Õë
     * */
    public int mostFrequentEven(int[] nums) {
        Arrays.sort(nums);
        int min = -1, max = 0, l = 0, r;
        while (l < nums.length) {
            while (l < nums.length && (nums[l] & 1) != 0) l++;
            if (l == nums.length) break;
            r = l + 1;
            while (r < nums.length && nums[r] == nums[l]) r++;
            int dis = r - l;
            if (dis > max) {
                max = dis;
                min = nums[l];
            }
            l = r;
        }
        return min;
    }

    @Test
    public void x() {
        int i = mostFrequentEven(new int[]{0, 1, 2, 2, 4, 4, 1});
        System.out.println(i);
    }
}
