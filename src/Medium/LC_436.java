package Medium;

import java.util.Arrays;
import java.util.Comparator;

public class LC_436 {

    public static void main(String[] args) {
        int[] rightInterval = findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}});
        for (int j : rightInterval) {
            System.out.print(j);
        }
    }

    public static int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        int[][] sort = new int[len][2];
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            sort[i][0] = intervals[i][0];
            sort[i][1] = i;
        }
        Arrays.sort(sort, Comparator.comparingInt(num -> num[0]));
        for (int i = 0; i < len; i++) {
            int left = 0, right = len - 1, tar = -1, num = intervals[i][1];
            while (left <= right) {
                int mid = (left + right) / 2;
                if (sort[mid][0] < num) {
                    left = mid + 1;
                } else if (sort[mid][0] >= num) {
                    right = mid - 1;
                    tar = sort[mid][1];
                }
            }
            ans[i] = tar;
        }
        return ans;
    }
}
