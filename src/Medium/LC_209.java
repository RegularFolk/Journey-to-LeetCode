package Medium;

public class LC_209 {
    /*
     * 滑动窗口模板题
     * r先往前走，如果sum超过了就一直让l往前走
     * */
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, sum = 0, min = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                min = Math.min(min, r - l + 1);
                sum -= nums[l++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
