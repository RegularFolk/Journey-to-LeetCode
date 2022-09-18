package Contest.YinLian_22_09_16;

import org.junit.Test;

import java.util.Arrays;

public class YinLian_2 {
    /*
     * 二分查找
     * 对于每一个pos[i]，在station中查找大于其的最小值和小于其的最大值，两者取一
     * */
    public int[] explorationSupply(int[] station, int[] pos) {
        for (int i = 0; i < pos.length; i++) {
            int left = findSmall(station, pos[i]);
            int right = findBigger(station, pos[i]);
            if (left != -1 && (right == -1 || pos[i] - station[left] <= station[right] - pos[i])) {
                pos[i] = left;
            } else pos[i] = right;
        }
        return pos;
    }

    /*
     * 找到大于等于tar的最小值
     * */
    private int findBigger(int[] station, int tar) {
        int pos = -1, l = 0, r = station.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (station[mid] >= tar) {
                pos = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return pos;
    }

    /*
     * 找到小于等于tar的最大值
     * */
    private int findSmall(int[] station, int tar) {
        int pos = -1, l = 0, r = station.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (station[mid] <= tar) {
                pos = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return pos;
    }

    @Test
    public void x() {
        int[] ints = explorationSupply(new int[]{5, 9, 10, 12, 15}, new int[]{8, 9, 4, 16, 17});
        System.out.println(Arrays.toString(ints));
    }
}
