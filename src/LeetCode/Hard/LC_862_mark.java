package LeetCode.Hard;

import org.junit.Test;

import java.util.LinkedList;

public class LC_862_mark {
    /*
     * 前缀和+单调队列
     * 维护一个单调递增的前缀和单调队列
     * 构造前缀和数组，问题转换成在这个数组找最近的两下标对应元素之差大于等于k
     * 利用单调队列再去解决转换后的问题
     * 后入队的数如果比队尾更小，应该不断弹出，因为后入表示下标更靠后，同时更小未来作差后会更大，更容易符合题意
     * */
    public int shortestSubarray(int[] nums, int k) {
        long[] preSum = getPreSum(nums);
        int ans = Integer.MAX_VALUE;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        for (int i = 1; i < preSum.length; i++) {
            while (list.size() > 0 && preSum[list.getLast()] >= preSum[i]) list.removeLast();
            list.addLast(i);
            while (list.size() > 1 && preSum[list.getLast()] - preSum[list.getFirst()] >= k) {
                ans = Math.min(ans, list.getLast() - list.removeFirst());
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private long[] getPreSum(int[] nums) {
        long[] ans = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            ans[i + 1] = ans[i] + nums[i];
        }
        return ans;
    }

    @Test
    public void x() {
        int i = shortestSubarray(new int[]{56, -21, 56, 35, -9}, 61);
        System.out.println(i);
    }
}
