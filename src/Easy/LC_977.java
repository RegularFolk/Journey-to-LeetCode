package Easy;

public class LC_977 {
    /*
     * 找到绝对值最小元素的下标往两边迭代
     * */
    public int[] sortedSquares(int[] nums) {
        int pos = 0;
        while (pos < nums.length - 1 && Math.abs(nums[pos + 1]) <= Math.abs(nums[pos])) {
            pos++;
        }
        int[] ans = new int[nums.length];
        ans[0] = nums[pos] * nums[pos];
        for (int cursor = 1, left = pos - 1, right = pos + 1; left >= 0 || right < nums.length; cursor++) {
            if (left >= 0 && (right == nums.length || Math.abs(nums[left]) < Math.abs(nums[right]))) {
                ans[cursor] = nums[left] * nums[left];
                left--;
            } else {
                ans[cursor] = nums[right] * nums[right];
                right++;
            }
        }
        return ans;
    }
}
