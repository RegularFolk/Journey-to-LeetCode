package Medium;

import org.junit.Test;

import java.util.PriorityQueue;

public class LC_215_mark {
    /*
     * 最小堆
     * 时间复杂度nlogn
     * */
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            q.add(num);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }

    /*
     * 基于快速排序的查找，时间复杂度n
     * 代码细节爆炸
     * */
    public int findKthLargest2(int[] nums, int k) {
        return findK(nums, k, 0, nums.length - 1);
    }

    private int findK(int[] nums, int k, int left, int right) {
        int pos = partition(nums, left, right);
        int rank = right - pos + 1;
        if (rank == k) {
            return nums[pos];
        } else if (rank < k) {
            return findK(nums, k - rank, left, pos - 1);
        } else {
            return findK(nums, k, pos + 1, right);
        }
    }

    /*
     * 返回将pivot快速排序后其所处的位置
     * */
    private int partition(int[] nums, int left, int right) {
        int l = left + 1, r = right;
        while (l < r) {
            while (l < right && nums[l] <= nums[left]) l++;
            while (r > left && nums[r] > nums[left]) r--;
            if (r > l) {
                swap(nums, l, r);
            }
        }
        if (nums[r] <= nums[left]) {
            swap(nums, left, r);
            return r;
        } else {
            return left;
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }


    @Test
    public void s() {
        int i = findKthLargest2(new int[]{-1, -1}, 2);
        System.out.println(i);
    }
}
