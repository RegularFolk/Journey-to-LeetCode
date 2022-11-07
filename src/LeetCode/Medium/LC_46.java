package LeetCode.Medium;

import java.util.*;

import static java.util.Collections.swap;

public class LC_46 {
    /*
     * nextPermutation问题，回溯
     * */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        ArrayList<Integer> num = new ArrayList<>(nums.length);
        for (int i : nums) {
            num.add(i);
        }
        nextPermutation(ans, num, 0);
        return ans;
    }

    private void nextPermutation(List<List<Integer>> ans, ArrayList<Integer> nums, int n) {
        if (n == nums.size() - 1) {
            ans.add(new LinkedList<>(nums));
            return;
        }
        for (int i = n; i < nums.size(); i++) {
            swap(nums, n, i);
            nextPermutation(ans, nums, n + 1);
            swap(nums, n, i);
        }
    }
}
