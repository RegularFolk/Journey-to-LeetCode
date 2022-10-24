package Leet.Medium;

import java.util.Arrays;

public class LC_384 {
    public static class Solution {
        int[] origin;
        int[] copy;

        public Solution(int[] numbs) {
            copy = Arrays.copyOf(numbs, numbs.length);
            origin = numbs;
        }

        public int[] reset() {
            return origin;
        }

        public int[] shuffle() {
            for (int i = 1; i < copy.length; i++) {
                int r = (int) (Math.random() * copy.length);
                int temp = copy[r];
                copy[r] = copy[i];
                copy[i] = temp;
            }
            return copy;
        }
    }
}
