package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.swap;

public class LC_47 {
    /*
     * 包含重复的全排列，利用一个数组做散列表去重
     * */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        ArrayList<Integer> num = new ArrayList<>(nums.length);
        for (int i : nums) {
            num.add(i);
        }
        nextPermutation(ans, num, 0);
        return ans;
    }

    private void nextPermutation(List<List<Integer>> ans, ArrayList<Integer> num, int i) {
        if (i == num.size() - 1) {
            ans.add(new LinkedList<>(num));
            return;
        }
        boolean[] taken = new boolean[21];
        for (int j = i; j < num.size(); j++) {
            if (!taken[num.get(j) + 10]) {
                taken[num.get(j) + 10] = true;
                swap(num, i, j);
                nextPermutation(ans, num, i + 1);
                swap(num, i, j);
            }
        }
    }
}
