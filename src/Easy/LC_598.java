package Easy;

public class LC_598 {
    public static void main(String[] args) {

    }

    public static int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }
        int leftMin = ops[0][0];
        int rightMin = ops[0][1];
        for (int[] op : ops) {
            leftMin = Math.min(leftMin, op[0]);
            rightMin = Math.min(rightMin, op[1]);
        }
        return (leftMin) * (rightMin);
    }
}
