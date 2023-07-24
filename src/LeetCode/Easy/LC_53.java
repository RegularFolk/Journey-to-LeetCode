package LeetCode.Easy;

import java.util.Scanner;

public class LC_53 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(maxSubArrayLearntFromZJU(nums));
    }

    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                ans = Math.max(sum, ans);
            }
        }
        return ans;
    }

    public static int maxSubArrayLearntFromZJU(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > ans || i == 0) {
                ans = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
}

class redo_53 {
    /*
     * 经典的贪心
     * 一直往后加，直到和为负数，丢掉当前的累加
     * */
    public int maxSubArray(int[] nums) {
        int max = nums[0], cnt = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cnt < 0) cnt = 0;
            cnt += nums[i];
            max = Math.max(max, cnt);
        }
        return max;
    }
}
