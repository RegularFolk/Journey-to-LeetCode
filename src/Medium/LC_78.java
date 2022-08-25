package Medium;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class LC_78 {
    /*
     * 动态规划
     * dp[i]=dp[i-1]+(dp[i-1]中所有元素加上nums[i])
     * */
    public List<List<Integer>> subsets(int[] nums) {
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

    @Test
    public void s() {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        int size = 0;
        for (List<Integer> subset : subsets) {
            size += subset.size();
            System.out.print("[");
            for (Integer integer : subset) {
                System.out.print(integer + "\t");
            }
            System.out.println("]");
        }
        System.out.println("size = " + size);
    }
}
