package JzOffer.JzOffer_II;

import LeetCode.Medium.LC_146;

public class JzOfferII_031 {

    static class LRUCache {

        LC_146.LRUCache cache;

        public LRUCache(int capacity) {
            cache = new LC_146.LRUCache(capacity);
        }

        public int get(int key) {
            return cache.get(key);
        }

        public void put(int key, int value) {
            cache.put(key, value);
        }
    }
}
