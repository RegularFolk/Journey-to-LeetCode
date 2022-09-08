package Medium;

import org.junit.Test;
import utils.ArrayUtil;

import java.util.*;

public class LC_40_mark {
    /*
     * 经典permutation
     * 难点在去重
     * */
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        permutation(candidates, target, 0, new LinkedList<>());
        return ans;
    }

    private void permutation(int[] candidates, int target, int start, LinkedList<Integer> path) {
        if (target == 0) ans.add(List.copyOf(path));
        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            if (i == start || candidates[i] != candidates[i - 1]) {//<<<在这里去重
                path.addLast(candidates[i]);
                permutation(candidates, target - candidates[i], i + 1, path);
                path.removeLast();
            }
        }
    }


    @Test
    public void x() {
        List<List<Integer>> list = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        ArrayUtil.printDoubleList(list);
    }
}
