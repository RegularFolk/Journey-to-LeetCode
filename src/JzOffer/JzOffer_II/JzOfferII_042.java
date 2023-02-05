package JzOffer.JzOffer_II;

import java.util.Map;
import java.util.TreeMap;

public class JzOfferII_042 {
    /*
    * Ç°×ººÍ+TreeMap
    * */
    static class RecentCounter {
        private final TreeMap<Integer, Integer> map = new TreeMap<>();

        public RecentCounter() {

        }

        public int ping(int t) {
            Map.Entry<Integer, Integer> entry = map.floorEntry(t);
            int val = entry == null ? 1 : entry.getValue() + 1;
            map.put(t, val);
            Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(t - 3000);
            return val - ceilingEntry.getValue() + 1;
        }
    }
}
