package Medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class LC_6173_TODO {
    /*
     * 二进制枚举
     * */
    public int maximumRows(int[][] mat, int cols) {
        //TODO
        return 0;
    }

    @Test
    public void x() {
        int i = maximumRows(new int[][]{
                {1, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 1},
                {0, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 0, 1},
                {0, 1, 0, 0, 1, 0, 0, 0}}, 5);
        System.out.println(i);
    }
}
