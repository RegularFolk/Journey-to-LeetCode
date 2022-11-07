package LeetCode.Easy;

public class LC_6200 {
    /*
    * n是没用的，抽象题目
    * */
    public int hardestWorker(int n, int[][] logs) {
        int lastOver = 0, ans = 0, max = -1;
        for (int[] log : logs) {
            int time = log[1] - lastOver;
            if (time > max) {
                ans = log[0];
                max = time;
            } else if (time == max) {
                ans = Math.min(ans, log[0]);
            }
            lastOver = log[1];
        }
        return ans;
    }
}
