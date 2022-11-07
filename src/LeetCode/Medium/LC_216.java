package LeetCode.Medium;

import org.junit.Test;
import utils.ArrayUtil;

import java.util.LinkedList;
import java.util.List;

public class LC_216 {
    /*
     * Permutation问题
     * 回溯+剪枝
     * */
    private final List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        permutation(k, n, 1, new LinkedList<>());
        return ans;
    }

    /*
     * start表示从数组哪个下标开始
     * */
    private void permutation(int k, int target, int start, LinkedList<Integer> cur) {
        if (k == 0 && target == 0) ans.add(List.copyOf(cur));
        else if (k > 0 && target > 0) {
            for (int i = start; i <= 10 - k; i++) {
                if (target >= i) {
                    cur.addLast(i);
                    permutation(k - 1, target - i, i + 1, cur);
                    cur.removeLast();
                }
            }
        }
    }

    @Test
    public void x() {
        List<List<Integer>> list = combinationSum3(3, 7);
        ArrayUtil.printDoubleList(list);
    }
}
