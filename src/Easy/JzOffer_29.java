package Easy;

import java.util.Scanner;

/*
打印矩阵  未完成
*/
public class JzOffer_29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int count = 0;
        int[] ans = new int[matrix.length * matrix.length];
        int dir = 1;
        //1向右走  2向下走  3向左走  4向上走
        int x = 0;
        int y = 0;
        int[][] map = new int[matrix.length][matrix.length];
        while (count < matrix.length * matrix.length) {
            for (; map[y][x] == 0; x++) {//向右走
                ans[count++] = matrix[y][x];
                map[y][x] = 1;
                if (x == matrix.length - 1) {
                    x--;
                }
            }
            if (count == matrix.length * matrix.length) {
                break;
            }
            for (; map[y][x] == 0; y++) {//向下走
                ans[count++] = matrix[y][x];
                map[y][x] = 1;
                if (y == matrix.length - 1) {
                    y--;
                }
            }
            if (count == matrix.length * matrix.length) {
                break;
            }
            for (; map[y][x] == 0; x--) {//向左走
                ans[count++] = matrix[y][x];
                map[y][x] = 1;
                if (x == 0) {
                    x++;
                }
            }
            if (count == matrix.length * matrix.length) {
                break;
            }
            for (; map[y][x] == 0; y--) {//向上走
                ans[count++] = matrix[y][x];
                map[y][x] = 1;
                if (y == 0) {
                    y++;
                }
            }
            if (count == matrix.length * matrix.length) {
                break;
            }
        }
    }
}


/*
            if (dir == 1) {//向右走，变横坐标
                for (; map[y][x] == 0; x++) {
                    ans[count] = matrix[y][x];
                    count++;
                    map[y][x] = 1;
                }
                dir = 2;
                x--;
            } else if (dir == 2) {//向下走，变纵坐标
                for (; map[y][x] == 0; y++) {
                    ans[count] = matrix[y][x];
                    count++;
                    map[y][x] = 1;
                }
                dir = 3;
                y--;
            } else if (dir == 3) {//向左走，变纵坐标
                for (; map[y][x] == 0; x--) {
                    ans[count] = matrix[y][x];
                    count++;
                    map[y][x] = 1;
                }
                dir = 4;
                x++;
            } else if (dir == 4) {//向上走
                for (; map[y][x] == 0; y--) {
                    ans[count] = matrix[y][x];
                    count++;
                    map[y][x] = 1;
                }
                dir = 1;
                y++;
            }
            */
