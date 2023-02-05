package JzOffer.JzOffer_II;

import java.util.LinkedList;

public class JzOfferII_041 {
    static class MovingAverage {
        private final LinkedList<Integer> list = new LinkedList<>();
        private int size = 0;
        private double sum = 0;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
            list.addLast(val);
            sum += val;
            if (list.size() == size + 1) sum -= list.removeFirst();
            return sum / list.size();
        }
    }
}
