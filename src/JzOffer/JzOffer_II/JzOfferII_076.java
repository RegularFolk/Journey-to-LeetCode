package JzOffer.JzOffer_II;

public class JzOfferII_076 {
    /*
    * 快速选择模板题
    * */
    public int findKthLargest(int[] nums, int k) {
        return qPick(nums, nums.length - k, 0, nums.length - 1);
    }

    private int qPick(int[] nums, int tar, int left, int right) {
        int pivot = nums[left];
        int l = left - 1, r = right + 1;
        while (l < r) {
            do l++; while (nums[l] < pivot);
            do r--; while (nums[r] > pivot);
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        int rank = r + 1;
        if (pivot == nums[left]) rank = r;
        if (rank == tar) return pivot;
        else if (rank > tar) return qPick(nums, tar, left, r);
        else return qPick(nums, tar, r + 1, right);
    }
}
