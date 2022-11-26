package JzOffer.JzOffer_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JzOfferII_007 {
    /*
     * 三数之和
     * 通过双指针优化时间复杂度为n^2
     * 通过规定三数最小值去重
     * */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int tar = -nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == tar) {
                    ans.add(List.of(nums[l], nums[r], nums[i]));
                    l = nextL(l, nums) + 1;
                } else if (sum < tar) {
                    l = nextL(l, nums) + 1;
                } else r = nextR(r, nums) - 1;
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
