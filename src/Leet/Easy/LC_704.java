package Leet.Easy;

public class LC_704 {
    public int search(int[] nums, int target) {
        return binFind(nums, target, 0, nums.length - 1);
    }

    private int binFind(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) >> 1;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) return binFind(nums, target, left, mid - 1);
        else return binFind(nums, target, mid + 1, right);
    }
}
