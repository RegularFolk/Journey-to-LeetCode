package LeetCode.Medium;

import java.util.HashSet;
import java.util.Set;

public class LC_519 {
    static class Solution {
        Set<String> used;
        int m;
        int n;

        public Solution(int m, int n) {
            this.m = m;
            this.n = n;
            used = new HashSet<>();
        }

        public int[] flip() {
            int x;
            int y;
            do {
                x = (int) (Math.random() * m);
                y = (int) (Math.random() * n);
            } while (used.contains(x + ":" + y));
            used.add(x + ":" + y);
            return new int[]{x, y};
        }

        public void reset() {
            used.clear();
        }
    }
}
