package JzOffer.JzOffer_II;

import java.util.*;

public class JzOfferII_058 {
    /*
     * 逐个区间判断即可，不要想复杂
     * */
    static class MyCalendar {

        LinkedList<int[]> list = new LinkedList<>();

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            for (int[] next : list) {
                if (next[0] < end && next[1] > start) return false;
            }
            list.add(new int[]{start, end});
            return true;
        }
    }
}
