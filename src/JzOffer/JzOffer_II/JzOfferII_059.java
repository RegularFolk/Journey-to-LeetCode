package JzOffer.JzOffer_II;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class JzOfferII_059 {
    /*
     * С����
     * ע�����,��K��˵��������K����������С��
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
