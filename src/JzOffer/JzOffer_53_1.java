package JzOffer;

import org.junit.Test;

public class JzOffer_53_1 {
    @Test
    public void te() {
        int search = search1(new int[]{1}, 1);
        System.out.println("search = " + search);
    }

    public int search1(int[] nums, int target) {  //复杂度可能退化为n
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int spot = bSearch(nums, target), ans = 1;
        if (spot == -1) {
            return 0;
        }
        for (int i = spot - 1; i >= 0; i--) {
            if (nums[i] != target) {
                break;
            }
            ans++;
        }
        for (int i = spot + 1; i < nums.length; i++) {
            if (nums[i] != target) {
                break;
            }
            ans++;
        }
        return ans;
    }

    private int bSearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {  //改变查找条件，进行两次二分查找
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int first = getFirst(nums, target, 0, nums.length - 1);
        int last = getLast(nums, target, 0, nums.length - 1);
        return first != -1 && last != -1 ? last - first + 1 : 0;
    }

    private int getLast(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) >> 1;
        if (nums[mid] == target) {
            if ((mid < nums.length - 1 && nums[mid + 1] != target) || mid == nums.length - 1) {
                return mid;
            } else {
                return getLast(nums, target, mid + 1, right);
            }
        } else if (nums[mid] > target) {
            return getLast(nums, target, left, mid - 1);
        } else {
            return getLast(nums, target, mid + 1, right);
        }
    }

    private int getFirst(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) >> 1;
        if (nums[mid] == target) {
            if ((mid > 0 && nums[mid - 1] != target) || mid == 0) {
                return mid;
            } else {
                return getFirst(nums, target, left, mid - 1);
            }
        } else if (nums[mid] > target) {
            return getFirst(nums, target, left, mid - 1);
        } else {
            return getFirst(nums, target, mid + 1, right);
        }
    }
}
