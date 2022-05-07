package Medium;

public class LC_56 {
    public static void main(String[] args) {

    }

    public static int[][] merge(int[][] intervals) {
        quickSort(intervals, 0, intervals.length - 1);
        int n = 1;
        int[][] ans = new int[intervals.length][2];
        ans[0] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > ans[n - 1][1]) {    //不满足合并要求
                ans[n] = intervals[i];
                n++;
            } else if (intervals[i][0] >= ans[n - 1][0] && intervals[i][0] <= ans[n - 1][1] &&
                    intervals[i][1] >= ans[n - 1][1]) {//满足合并
                ans[n - 1][1] = intervals[i][1];
            }
        }
        int[][] output = new int[n][2];
        System.arraycopy(ans, 0, output, 0, n);
        return output;
    }

    public static void quickSort(int[][] intervals, int left, int right) {
        int[] temp;
        int leftCursor = left;
        int rightCursor = right;
        int[] pivot = intervals[(left + right) / 2];
        while (rightCursor > leftCursor) {
            while (intervals[leftCursor][0] < pivot[0]) {
                leftCursor++;
            }
            while (intervals[rightCursor][0] > pivot[0]) {
                rightCursor--;
            }
            if (rightCursor >= leftCursor) {
                temp = intervals[leftCursor];
                intervals[leftCursor] = intervals[rightCursor];
                intervals[rightCursor] = temp;
                leftCursor++;
                rightCursor--;
            }
        }
        if (leftCursor < right) {
            quickSort(intervals, leftCursor, right);
        }
        if (rightCursor > left) {
            quickSort(intervals, left, rightCursor);
        }
    }
}
