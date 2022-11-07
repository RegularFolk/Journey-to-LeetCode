package LeetCode.Medium;

public class LC_238 {
    /*
     * 空间复杂度为n，时间复杂度为n，不使用除法
     * 维护一个前缀数组和一个后缀数组
     * */
    public int[] productExceptSelf1(int[] nums) {
        int[] pre = new int[nums.length], suf = new int[nums.length];
        pre[0] = 1;
        suf[suf.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
            suf[suf.length - i - 1] = suf[suf.length - i] * nums[suf.length - i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = pre[i] * suf[i];
        }
        return nums;
    }

    /*
     * 常数空间复杂度，走两遍，先记录前缀，再记录后缀
     * */
    public int[] productExceptSelf2(int[] nums) {
        int[] ans = new int[nums.length];
        int cur = 1;
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            cur *= nums[i - 1];
            ans[i] = cur;

        }
        cur = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            cur *= nums[i + 1];
            ans[i] *= cur;
        }
        return ans;
    }
}
