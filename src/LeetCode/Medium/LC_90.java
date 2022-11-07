package LeetCode.Medium;

import java.util.*;

public class LC_90 {
    /*
     * 通过迭代生成所有子集，再去重
     * 击败5%，效率低，主要是序列化去重消耗算力
     * */
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> ans = new LinkedList<>();
        ans.add(new LinkedList<>());
        for (int num : nums) {
            LinkedList<List<Integer>> add = new LinkedList<>();
            for (List<Integer> an : ans) {
                add.add(new LinkedList<>(an));
            }
            for (List<Integer> list : add) {
                list.add(num);
            }
            ans.addAll(add);
        }
        return getAns(ans);
    }

    private List<List<Integer>> getAns(LinkedList<List<Integer>> ans) {
        Set<String> set = new HashSet<>();
        LinkedList<List<Integer>> out = new LinkedList<>();
        for (List<Integer> an : ans) {
            if (set.add(toString(an))) out.add(an);
        }
        return out;
    }

    private String toString(List<Integer> an) {
        StringBuilder builder = new StringBuilder();
        for (Integer integer : an) {
            builder.append(integer).append(" ");
        }
        return builder.toString();
    }

    /*
     * 树层去重，类似于LC_40
     * 优于法一
     * */
    private final List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        permutation(nums, 0, new LinkedList<>());
        return ans;
    }

    private void permutation(int[] nums, int start, LinkedList<Integer> path) {
        ans.add(List.copyOf(path));
        if (start < nums.length) {
            for (int i = start; i < nums.length; i++) {
                if (i == start || nums[i] != nums[i - 1]) {
                    path.addLast(nums[i]);
                    permutation(nums, i + 1, path);
                    path.removeLast();
                }
            }
        }
    }
}
