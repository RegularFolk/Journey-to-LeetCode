package LeetCode.Medium;

public class LC_57 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 7};
        int[][] temp = insert(intervals, newInterval);
        for (int[] i : temp) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        int[][] ans = new int[intervals.length][2];
        int n = 0;
        boolean flag = false;//插入是否完成
        for (int i = 0; i < intervals.length; i++) {
            if (flag || newInterval[0] > intervals[i][1]) {
                ans[n] = intervals[i];
                n++;
            } else {
                if (newInterval[0] >= intervals[i][0] && newInterval[1] <= intervals[i][1]) {            //插入区间小于已有区间
                    return intervals;
                } else {
                    ans[n][0] = Math.min(newInterval[0], intervals[i][0]);
                    for (int j = i + 1; j < intervals.length; j++) {
                        if (newInterval[1] < intervals[j][1] || newInterval[1] < intervals[j][0]) {
                            if (newInterval[1] < intervals[j][0]) {
                                ans[n][1] = newInterval[1];
                                i = j - 1;
                            } else if (newInterval[1] < intervals[j][1]) {
                                ans[n][1] = intervals[j][1];
                                i = j;
                            }
                            flag = true;
                            n++;
                            break;
                        } else if (j == intervals.length - 1) {
                            ans[n][1] = newInterval[1];
                            n++;
                            i = j;
                            flag = true;
                        }
                    }
                }
            }
        }
        if (!flag) {
            ans[n] = newInterval;
            n++;
        }
        int[][] output = new int[n][2];
        System.arraycopy(ans, 0, output, 0, n);
        return output;
    }
}
