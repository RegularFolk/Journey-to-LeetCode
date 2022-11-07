package LeetCode.Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

public class LC_933 {

    static class RecentCounter {
        TreeSet<Integer> record = new TreeSet<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0;

        public RecentCounter() {

        }

        public int ping(int t) {
            map.put(t, count);
            count++;
            record.add(t);
            Integer ceiling = record.ceiling(t - 3000);
            return map.get(t) - map.get(ceiling) + 1;
        }
    }

    static class RecentCounter1 {
        Queue<Integer> queue = new LinkedList<>();

        public RecentCounter1() {
        }

        public int ping(int t) {
            queue.add(t);
            while (queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }
}
