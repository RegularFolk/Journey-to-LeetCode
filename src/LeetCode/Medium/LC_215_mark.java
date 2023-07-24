package LeetCode.Medium;

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
        if (nums[r] <= nums[left]) {//这个判断处理只有两个有序元素的情况，例如[5,6]，若不加判断会把5,6交换
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


class redo_215 {
    /*
     * 快速选择，基于快速排序
     * */
    public int findKthLargest(int[] nums, int k) {
        return findK(nums, k, 0, nums.length - 1);
    }

    /**
     * <pre>
     * 递归选择方法
     * 快速选择思路：
     *  每轮选择一个pivot，比它大的放左边边，比它小的放右边，判断出它是第几大
     *  如果等于k，直接返回
     *  如果大于k，说明比目标小，在左侧继续寻找
     *  如果小于k，说明比目标大，在右侧继续寻找
     * 快速选择本质上是部分排序
     * pivot可以任意取一个，在这里取原本数组中最左边一个数
     * </pre>
     *
     * @param nums 待选的数组
     * @param k    第K大的
     * @param l    待选数组左侧起始下标
     * @param r    待选数组右侧结尾下标
     * @return 选出的数
     */
    private int findK(int[] nums, int k, int l, int r) {
        int pos = partition(nums, l, r); // pivot在当前是第几大的
        int rank = pos + 1;
        if (rank == k) {
            return nums[pos];
        } else if (rank > k) {
            return findK(nums, k, l, pos - 1);
        } else {
            return findK(nums, k, pos + 1, r);
        }
    }

    // 找出下标l对应的数是位于哪个下标的
    private int partition(int[] nums, int l, int r) {
        return 0;
    }
}
