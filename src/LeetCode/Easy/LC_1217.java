package LeetCode.Easy;

public class LC_1217 {
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        for (int i : position) {
            odd += i & 1;
        }
        return Math.min(odd, position.length - odd);
    }
}
