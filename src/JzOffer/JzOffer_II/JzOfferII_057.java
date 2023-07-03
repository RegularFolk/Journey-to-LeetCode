package JzOffer.JzOffer_II;

import org.junit.Test;

import java.util.LinkedList;
import java.util.TreeSet;

public class JzOfferII_057 {

    /*
     * ´¿TreeSetÌâ
     * */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k == 0) return false;
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long v = nums[i];
            Long floor = treeSet.floor(v);
            Long ceil = treeSet.ceiling(v);
            if ((floor != null && v - floor <= t) || (ceil != null && ceil - v <= t)) return true;
            treeSet.add(v);
            if (i >= k) treeSet.remove((long) nums[i - k]);
        }
        return false;
    }
}
