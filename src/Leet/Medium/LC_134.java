package Leet.Medium;

public class LC_134 {
    /*
     * Ì°ÐÄ
     * */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int mark = 0, curSum = 0, sum = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            curSum += diff;
            sum += diff;
            if (curSum < 0) {
                mark = i + 1;
                curSum = 0;
            }
        }
        return sum >= 0 ? mark : -1;
    }
}
