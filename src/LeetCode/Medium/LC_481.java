package LeetCode.Medium;

import java.util.ArrayList;

public class LC_481 {
    /*
     * 模拟，逐个往后生成
     * */
    public int magicalString(int n) {
        if (n <= 3) return 1;
        int ans = 1;
        ArrayList<Boolean> queue = new ArrayList<>();
        queue.add(true);
        queue.add(false);
        queue.add(false);
        for (int i = 2; i < n; i++) {
            boolean put = !queue.get(queue.size() - 1);
            if (queue.get(i)) {
                queue.add(put);
                ans++;
            } else {
                queue.add(put);
                queue.add(put);
            }
        }
        return ans;
    }
}
