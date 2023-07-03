package JzOffer.JzOffer_II;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class JzOfferII_059 {
    /*
     * 小根堆
     * 注意读题,第K大说明在最大的K个数中是最小的
     * */
    static class KthLargest {

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        private final int limit;

        public KthLargest(int k, int[] nums) {
            limit = k;
            for (int num : nums) heap.add(num);
        }

        public int add(int val) {
            heap.add(val);
            while (heap.size() > limit) heap.poll();
            return heap.peek();
        }
    }
}
