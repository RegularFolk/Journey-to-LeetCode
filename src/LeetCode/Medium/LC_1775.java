package LeetCode.Medium;


public class LC_1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        int[] change = new int[6];
        int sum1 = 0, sum2 = 0, diff, ans = 0;
        for (int i : nums1) sum1 += i;
        for (int i : nums2) sum2 += i;
        for (int i : sum1 >= sum2 ? nums1 : nums2) change[i - 1]++;
        for (int i : sum1 < sum2 ? nums1 : nums2) change[6 - i]++;
        diff = Math.abs(sum1 - sum2);
        for (int i = 5; i > 0 && diff != 0; i--) {
            if (diff >= change[i] * i) {
                diff -= change[i] * i;
                ans += change[i];
            } else {
                ans += (diff / i) + (diff % i == 0 ? 0 : 1);
                return ans;
            }
        }
        return diff == 0 ? ans : -1;
    }
}
