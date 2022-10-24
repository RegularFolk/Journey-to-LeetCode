package JzOffer.JzOffer_I;

public class JzOffer_57_1 {
    public int[] twoSum1(int[] nums, int target) {  //二分查找  时间复杂度nlogn
        if (nums.length < 2) {
            return new int[2];
        }
        int[] ans = new int[2];
        for (int i = 0; i < nums.length && nums[i] < target && target - nums[i] >= nums[i]; i++) {
            int tar = target - nums[i], temp = 0;
            temp = bSearch(nums, tar, i + 1, nums.length - 1);
            if (temp != -1) {
                ans[0] = nums[i];
                ans[1] = nums[temp];
                return ans;
            }
        }
        throw new RuntimeException();
    }

    private int bSearch(int[] nums, int tar, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) >> 1;
        if (nums[mid] == tar) {
            return mid;
        } else if (nums[mid] > tar) {
            return bSearch(nums, tar, left, mid - 1);
        } else {
            return bSearch(nums, tar, mid + 1, right);
        }
    }

    public int[] twoSum2(int[] nums, int target) { //双指针 最优解，不过需要正确性证明
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int s = nums[left] + nums[right];
            if (s < target) {
                left++;
            } else if (s > target) {
                right--;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        throw new RuntimeException();
    }
}
