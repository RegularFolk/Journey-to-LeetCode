package Medium;

public class LC_713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0 || k == 1) {
            return 0;
        }
        int head = 0, tail = 0, ans = 0, multiPool = 1, len = nums.length;
        while (head < len) {
            multiPool *= nums[head];
            while (multiPool >= k) {
                multiPool /= nums[tail];
                tail++;
            }
            ans += head - tail + 1;
            head++;
        }
        return ans;
    }
}
