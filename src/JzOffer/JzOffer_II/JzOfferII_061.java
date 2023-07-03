package JzOffer.JzOffer_II;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class JzOfferII_061 {
    /*
     * 利用小根堆，直接往堆里丢就行
     * 没有利用到两个数组有序的条件
     * */
    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0] + a[1]));
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                heap.add(new int[]{n1, n2});
            }
        }
        while (k-- > 0 && !heap.isEmpty()) {
            int[] poll = heap.poll();
            ans.add(List.of(poll[0], poll[1]));
        }
        return ans;
    }

}
