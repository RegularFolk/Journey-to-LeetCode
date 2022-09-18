package Contest.YinLian_22_09_16;

import org.junit.Test;

import java.util.Arrays;

public class YinLian_2 {
    /*
     * ���ֲ���
     * ����ÿһ��pos[i]����station�в��Ҵ��������Сֵ��С��������ֵ������ȡһ
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
     * �ҵ����ڵ���tar����Сֵ
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
     * �ҵ�С�ڵ���tar�����ֵ
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
