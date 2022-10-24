package Leet.Medium;

import org.junit.Test;
import utils.ArrayUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC_39 {
    /*
     * 递归+回溯
     * 注意数据范围，candidates[i]<=target时退出
     * 排序后逐个选取作为组合中的最小值
     * */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(candidates);
        permutation(ans, candidates, new LinkedList<>(), 0, target);
        return ans;
    }

    private void permutation(LinkedList<List<Integer>> ans, int[] candidates, LinkedList<Integer> cur, int start, int target) {
        if (start < candidates.length) {
            if (target == 0) {
                ans.add(List.copyOf(cur));
            } else {
                for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
                    cur.addLast(candidates[i]);
                    permutation(ans, candidates, cur, i, target - candidates[i]);
                    cur.removeLast();
                }
            }
        }
    }

    @Test
    public void s() {
        List<List<Integer>> lists = combinationSum(new int[]{2, 3, 6, 7}, 7);
        ArrayUtil.printDoubleList(lists);
    }
}
