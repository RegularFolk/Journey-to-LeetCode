package JzOffer.JzOffer_I;

import org.junit.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class JzOffer_59_1 {
    public int[] maxSlidingWindow1(int[] nums, int k) {  //利用大根堆，时间复杂度为nlogk，会超时
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        ans[0] = queue.peek();
        for (int i = k, count = 1; i < nums.length; i++, count++) {
            queue.remove(nums[i - k]);
            queue.add(nums[i]);
            ans[count] = queue.peek();
        }
        return ans;
    }

    @Test
    public void t() {
        int[] ints = maxSlidingWindow2(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5);
        for (int anInt : ints) {
            System.out.println("i = " + anInt);
        }
    }

    /*
    * 单调队列模板题，同Hard LC_239
    * */
    public int[] maxSlidingWindow2(int[] nums, int k) {   //维护一个单调队列，仅储存可能的最大值
        int[] ans = new int[nums.length - k + 1];
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        for (int i = 1; i < k; i++) {
            while (list.size() > 0 && nums[list.getLast()] <= nums[i]) {
                list.removeLast();
            }
            list.add(i);
        }
        ans[0] = nums[list.getFirst()];
        for (int i = k, count = 1; i < nums.length; i++, count++) {
            if (list.getFirst() == i - k) {
                list.removeFirst();
            }
            while (list.size() > 0 && nums[list.getLast()] <= nums[i]) {
                list.removeLast();
            }
            list.add(i);
            ans[count] = nums[list.getFirst()];
        }
        return ans;
    }
}
