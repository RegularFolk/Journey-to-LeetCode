package Contest.TianTangGuiGu_22_09_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NO_1 {
    /*
    * ´ó¸ù¶Ñ
    * */
    public int lastMaterial(int[] material) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(value -> -1 * value));
        for (int i : material) {
            heap.add(i);
        }
        while (heap.size() >= 2) {
            int a = heap.poll(), b = heap.poll();
            heap.add(a - b);
        }
        return heap.size() == 0 ? 0 : heap.poll();
    }
}
