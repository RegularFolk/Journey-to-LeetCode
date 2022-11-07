package LeetCode.Easy;

public class LC_812 {
    public double largestTriangleArea(int[][] points) {
        int len = points.length;
        double ans = 0;
        for (int i = 0; i < len - 2; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = 1; j < len - 1; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int x1y2 = x1 * y2;
                int x2y1 = x2 * y1;
                for (int k = 2; k < len; k++) {
                    int y3 = points[k][1];
                    int x3 = points[k][0];
                    double square = Math.abs((float) (x1y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2y1 - x3 * y2));
                    ans = Math.max(ans, square);
                }
            }
        }
        return ans / 2;
    }
}
