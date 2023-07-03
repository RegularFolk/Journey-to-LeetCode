package JzOffer.JzOffer_II;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class JzOfferII_075 {
    /*
     * 用map定义一个comparator
     * */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) map.put(arr2[i], i);
        Integer[] arr = new Integer[arr1.length];
        for (int i = 0; i < arr.length; i++) arr[i] = arr1[i];
        Arrays.sort(arr, (a, b) -> {
            Integer av = map.get(a);
            Integer bv = map.get(b);
            if (av == null && bv == null) return a - b;
            else if (av != null && bv != null) return av - bv;
            else return av == null ? 1 : -1;
        });
        for (int i = 0; i < arr1.length; i++) arr1[i] = arr[i];
        return arr1;
    }
}
