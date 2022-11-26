package LeetCode.Easy;

public class LC_1732 {
    public int largestAltitude(int[] gain) {
        int height = 0, max = 0;
        for (int i : gain) {
            height += i;
            max = Math.max(max, height);
        }
        return max;
    }
}
