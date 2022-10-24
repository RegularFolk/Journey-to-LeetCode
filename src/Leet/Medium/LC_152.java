package Leet.Medium;

public class LC_152 {
    /*
     * 维护两个值，一个为最大值，一个为最小值
     * 滚动数组
     * */
    public int maxProduct(int[] nums) {
        int max = 1, min = 1, ans = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * num, num);
            min = Math.min(min * num, num);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
