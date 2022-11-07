package LeetCode.Medium;

import java.util.*;

public class LC_90 {
    /*
     * ͨ���������������Ӽ�����ȥ��
     * ����5%��Ч�ʵͣ���Ҫ�����л�ȥ����������
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
     * ����ȥ�أ�������LC_40
     * ���ڷ�һ
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
