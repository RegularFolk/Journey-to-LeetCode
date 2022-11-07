package LeetCode.Easy;

import java.util.LinkedList;
import java.util.List;

public class LC_448 {
    /*
     * Ô­µØ¹şÏ£
     * */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        LinkedList<Integer> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = nums[index] > 0 ? nums[index] * -1 : nums[index];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
