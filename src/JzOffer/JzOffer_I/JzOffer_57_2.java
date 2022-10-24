package JzOffer.JzOffer_I;

import java.util.LinkedList;
import java.util.List;

public class JzOffer_57_2 {
    public int[][] findContinuousSequence(int target) {  //双指针,和上一题实际上是相同的，相当于有一个无限长的备选数组
        if (target < 3) {
            return null;
        }
        int left = 1, right = 2, sum = 3, mid = (target + 1) >> 1;
        List<int[]> ans = new LinkedList<>();
        while (left < mid) {
            if (sum == target) {
                int[] ints = new int[right - left + 1];
                for (int i = 0; i <= right - left; i++) {
                    ints[i] = left + i;
                }
                ans.add(ints);
                right++;
                sum += right;
            } else if (sum < target) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }
        }
        return ans.toArray(int[][]::new);
    }
}
