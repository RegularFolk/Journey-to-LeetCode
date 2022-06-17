package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class LC_1089 {
    public void duplicateZeros(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int cursor = 0, len = arr.length;
        while (cursor < len && arr[cursor] != 0) {
            cursor++;
        }
        cursor++;
        while (cursor < len) {
            if (arr[cursor] == 0) {
                queue.add(0);
                queue.add(0);
            } else {
                queue.add(arr[cursor]);
            }
            arr[cursor++] = queue.poll();
        }
    }
}
