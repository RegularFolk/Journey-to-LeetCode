package Medium;

import org.junit.Test;

import java.util.Arrays;

public class LC_2352 {
    /*
     * 矩阵转置后暴力比较
     * n^2时间复杂度居然可以击败九十
     * */
    public int equalPairs(int[][] grid) {
        int[][] clone = new int[grid.length][grid.length];
        for (int i = 0; i < clone.length; i++) {//矩阵转置
            for (int j = i; j < clone.length; j++) {
                swap(grid, clone, i, j);
            }
        }
        int ans = 0;
        for (int[] g : grid) {
            for (int[] c : clone) {
                if (Arrays.equals(g, c)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private void swap(int[][] grid, int[][] clone, int i, int j) {
        clone[i][j] = grid[j][i];
        clone[j][i] = grid[i][j];
    }

    @Test
    public void t() {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] b = a.clone();
        b[0][0] = 0;
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print("\t" + anInt);
            }
            System.out.println();
        }
        System.out.println("==============");
        for (int[] ints : b) {
            for (int anInt : ints) {
                System.out.print("\t" + anInt);
            }
            System.out.println();
        }

        /*
        * 数组的clone拷贝的是引用，浅拷贝，而不是重新创建一个对象，
        * 对clone后的对象进行修改会影响原对象
        *
        * ☆但是clone对于对象是深拷贝☆
        *
        * 数组的拷贝有三种方法，System.arraycopy(),Arrays.copyOf,Object.clone(),均为浅拷贝
        * */
    }
}
