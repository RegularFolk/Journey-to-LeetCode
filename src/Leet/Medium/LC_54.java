package Leet.Medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LC_54 {
    /*
    * 利用dir表示四个方向，b1,b2,b3,b4表示四个边界，一步一步走
    * 别写错代码就行
    * */
    public List<Integer> spiralOrder(int[][] matrix) {
        int step = matrix.length * matrix[0].length, dir = 1;//1右，2下，3左，4上
        int b1 = matrix[0].length - 1, b2 = matrix.length - 1, b3 = 0, b4 = 1;
        List<Integer> ans = new ArrayList<>(step);
        for (int i = 0, x = 0, y = 0; i < step; i++) {
            ans.add(matrix[y][x]);
            switch (dir) {
                case 1:
                    if (x < b1) x++;
                    else {
                        dir = 2;
                        y++;
                        b1--;
                    }
                    break;
                case 2:
                    if (y < b2) y++;
                    else {
                        dir = 3;
                        x--;
                        b2--;
                    }
                    break;
                case 3:
                    if (x > b3) x--;
                    else {
                        dir = 4;
                        y--;
                        b3++;
                    }
                    break;
                case 4:
                    if (y > b4) y--;
                    else {
                        dir = 1;
                        x++;
                        b4++;
                    }
                    break;
                default:
                    break;
            }
        }
        return ans;
    }

    @Test
    public void s() {
        List<Integer> list = spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        for (Integer integer : list) {
            System.out.print(integer + "\t");
        }
    }
}
