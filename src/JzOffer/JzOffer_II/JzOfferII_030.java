package JzOffer.JzOffer_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class JzOfferII_030 {
    static class RandomizedSet {
        Map<Integer, Integer> map = new HashMap<>();
        //删除时用list最后一个元素替代待删除元素，再删除最后一个元素
        ArrayList<Integer> list = new ArrayList<>();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {

        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            Integer index = map.get(val);
            list.set(index, list.get(list.size() - 1));
            map.put(list.get(list.size() - 1), index);
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int index = (int) (Math.random() * list.size());
            return list.get(index);
        }
    }
}
