package LeetCode.Medium;

import java.util.LinkedList;

public class LC_300_mark {
    /*
     * LIS(Largest Increasing Subsequence)问题，最长上升子序列
     * DP dp[i]代表以i结尾的最长的严格递增序列
     * 时间复杂度O(n^2)
     * */
    public int lengthOfLIS1(int[] nums) {
        int ans = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /*
     * 贪心+二分优化，时间复杂度降为nlogn
     * dp[i]表示为长度为i的序列的最小末尾值，dp数组单调递增
     * 遍历时，比较若dp[ans]<nums[i],则dp[++ans]=nums[i]
     *      否则，在dp之前找到第一个比num[i]小的数dp[k],dp[k+1]=nums[i],
     *      这个查找利用二分
     * */
    public int lengthOfLIS2(int[] nums) {
        int ans = 1;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int num : nums) {
            if (num > dp[ans]) {
                dp[++ans] = num;
            } else {//二分查找，找小于当前值的最大值
                int l = 1, r = ans, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (dp[mid] < num) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }//若没有找到小的，则pos=0，将长度为1的末尾元素置为num
                dp[pos + 1] = num;
            }
        }
        return ans;
    }
}

class redo_300 {
    /*
     * 最长递增子序列
     * dp[i] 为以下标为 i 结尾的最长递增子序列
     * 对于每一个数往前找比起小的最长的
     * */
    public int lengthOfLIS(int[] nums) {
        int max = 1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}
