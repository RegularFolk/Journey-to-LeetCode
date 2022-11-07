package LeetCode.Medium;

public class LC_6169 {
    /*
     * 滑动窗口
     * 注意total或的处理
     * */
    public int longestNiceSubarray(int[] nums) {
        int ans = 1, l = 0, r = 1, total = nums[0];
        while (r < nums.length && l < nums.length) {
            while (r < nums.length && (nums[r] & total) == 0) {
                total |= nums[r];
                r++;
            }
            ans = Math.max(ans, r - l);
            if (r == nums.length) break;
            total = nums[r];
            l = r;
            r++;
            while (l > 0 && (nums[l - 1] & total) == 0) {
                total |= nums[l - 1];
                l--;
            }
        }
        return ans;
    }
}
