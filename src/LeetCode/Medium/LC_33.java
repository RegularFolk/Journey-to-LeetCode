package LeetCode.Medium;

public class LC_33 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public static int search(int[] nums, int target) {//两次二分，先通过二分找到分割点，再通过二分查找tar
        if (nums.length < 2) {
            return nums.length == 0 || nums[0] != target ? -1 : 0;
        }
        int l = 0, r = nums.length - 1;
        while (r > l) {//出来之后l和r相等，指向大于等于num[0]的最大值
            int mid = (r + l + 1) >> 1;
            if (nums[mid] >= nums[0]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (nums[0] <= target) {//判断tar在哪个区间里
            l = 0;
        } else {
            r = nums.length - 1;
            l++;
        }
        while (l <= r) {//第二次二分
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
