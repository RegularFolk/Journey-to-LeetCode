package Medium;

import org.junit.Test;
import utils.ArrayUtil;

import java.util.*;

public class LC_18 {
    /*
     * 在LC_15的基础上再套一层循环，n^3次时间复杂度
     * 使用set去重
     * */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                long required = (long) target - (long) nums[i] - (long) nums[j];
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    long sum = nums[l] + nums[r];
                    if (sum == required && confirmed(set, nums, i, j, l, r)) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    } else if (sum > required) r--;
                    else l++;
                }
            }
        }
        return ans;
    }

    private boolean confirmed(Set<String> set, int[] nums, int i, int j, int l, int r) {
        int[] arr = new int[]{nums[i], nums[j], nums[l], nums[r]};
        Arrays.sort(arr);
        return set.add(Arrays.toString(arr));
    }

    @Test
    public void x() {
        List<List<Integer>> lists = fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296);
        ArrayUtil.printDoubleList(lists);
    }
}
