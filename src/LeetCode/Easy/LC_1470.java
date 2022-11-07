package LeetCode.Easy;

public class LC_1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        for (int i = 0, cursor = 0; i < n; i++) {
            ans[cursor++] = nums[i];
            ans[cursor++] = nums[i + n];
        }
        return ans;
    }
}
