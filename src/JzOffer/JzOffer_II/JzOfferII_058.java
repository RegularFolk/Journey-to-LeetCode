package JzOffer.JzOffer_II;

import java.util.*;

public class JzOfferII_058 {
    /*
     * ��������жϼ��ɣ���Ҫ�븴��
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
