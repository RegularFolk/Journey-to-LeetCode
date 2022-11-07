package LeetCode.Medium;

import java.util.Arrays;
import java.util.LinkedList;

public class LC_406 {
    /*
     * ����h����k�����������k����
     * �ѵ��ڿ�������
     * */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : b[0] - a[0]);
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(int[][]::new);
    }
}
