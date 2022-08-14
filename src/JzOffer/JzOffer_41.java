package JzOffer;

import java.util.PriorityQueue;

public class JzOffer_41 {

    private static class MedianFinder {
        PriorityQueue<Integer> left; //大根堆
        PriorityQueue<Integer> right; //小根堆

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            left = new PriorityQueue<>((n1, n2) -> n2 - n1); //与默认的反过来比
            right = new PriorityQueue<>();
        }

        public void addNum(int num) {
            left.add(num);
            right.add(left.poll());
            if (left.size() + 1 < right.size()) {
                left.add(right.poll());  //维持左右平衡
            }
        }

        public double findMedian() {
            if (right.size() > left.size()) {
                return right.peek();
            }
            return (double) (left.peek() + right.peek()) / 2;
        }
    }
}
