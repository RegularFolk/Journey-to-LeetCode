package Leet.Medium;

import java.util.LinkedList;
import java.util.List;

public class LC_491 {
    /*
     * »ØËİ + È¥ÖØ
     * */
    private final List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        permutation(nums, 0, new LinkedList<>());
        return ans;
    }

    private void permutation(int[] nums, int start, LinkedList<Integer> path) {
        if (path.size() >= 2) ans.add(List.copyOf(path));
        boolean[] used = new boolean[201];
        for (int i = start; i < nums.length; i++) {
            if ((path.size() == 0 || nums[i] >= path.getLast()) && !used[nums[i] + 100]) {
                path.addLast(nums[i]);
                permutation(nums, i + 1, path);
                path.removeLast();
                used[nums[i] + 100] = true;
            }
        }
    }
}
