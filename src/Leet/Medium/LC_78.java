package Leet.Medium;

import org.junit.Test;
import utils.ArrayUtil;

import java.util.LinkedList;
import java.util.List;

public class LC_78 {
    /*
     * 动态规划
     * dp[i]=dp[i-1]+(dp[i-1]中所有元素加上nums[i])
     * */
    public List<List<Integer>> subsets1(int[] nums) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        ans.add(new LinkedList<>());
        for (int num : nums) {
            LinkedList<List<Integer>> add = new LinkedList<>();
            for (List<Integer> an : ans) {
                add.addLast(new LinkedList<>(an));
            }
            for (List<Integer> list : add) {
                list.add(num);
            }
            ans.addAll(add);
        }
        return ans;
    }

    /*
     * 利用回溯,更加简洁
     * */
    private final LinkedList<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> subsets2(int[] nums) {
        permutation(nums, 0, new LinkedList<>());
        return ans;
    }

    private void permutation(int[] nums, int start, LinkedList<Integer> path) {
        ans.add(List.copyOf(path));
        if (start < nums.length) {
            for (int i = start; i < nums.length; i++) {
                path.addLast(nums[i]);
                permutation(nums, i + 1, path);
                path.removeLast();
            }
        }
    }

    @Test
    public void s() {
        List<List<Integer>> subsets = subsets1(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        ArrayUtil.printDoubleList(subsets);
    }
}
