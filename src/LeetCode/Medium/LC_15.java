package LeetCode.Medium;

import org.junit.Test;
import utils.ArrayUtil;

import java.util.*;

public class LC_15 {
    /*
     * ��������һ��������ж������
     * ʱ�临�Ӷ�O(n^2)
     * */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    if (validate(set, nums[i], nums[l], nums[r])) {
                        packAns(ans, nums[i], nums[l], nums[r]);
                    }
                    r--;
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
            while (i < nums.length - 2 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return ans;
    }

    private boolean validate(Set<String> set, int num, int num1, int num2) {
        return set.add(num + "," + num1 + "," + num2);
    }

    private void packAns(List<List<Integer>> ans, int required, int num, int num1) {
        ArrayList<Integer> add = new ArrayList<>(3);
        add.add(required);
        add.add(num);
        add.add(num1);
        ans.add(add);
    }

    @Test
    public void s() {
        List<List<Integer>> lists = threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6});
        ArrayUtil.printDoubleList(lists);
    }
}

class redo_15 {
    /*
     * ȥ�صķ�ʽ��Ƚϴ��Ӱ������
     * ʹ��setȥ�ز�����Ч
     * */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int tar = -1 * nums[i], l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == tar) {
                    ans.add(List.of(nums[i], nums[l], nums[r]));
                    l = nextL(l, nums) + 1;
                } else if (sum > tar) {
                    r = nextR(r, nums) - 1;
                } else {
                    l = nextL(l, nums) + 1;
                }
            }
            i = nextL(i, nums);
        }
        return ans;
    }

    private int nextR(int r, int[] nums) {
        while (r - 1 >= 0 && nums[r] == nums[r - 1]) r--;
        return r;
    }

    private int nextL(int l, int[] nums) {
        while (l + 1 < nums.length && nums[l] == nums[l + 1]) l++;
        return l;
    }
}
