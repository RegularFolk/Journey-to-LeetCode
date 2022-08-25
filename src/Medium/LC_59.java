package Medium;

public class LC_59 {
    /*
    * 与LC_54同样的思路
    * */
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int step = n * n, dir = 1, b1 = n - 1, b2 = n - 1, b3 = 0, b4 = 1;
        for (int i = 1, x = 0, y = 0; i <= step; i++) {
            ans[y][x] = i;
            switch (dir) {
                case 1:
                    if (x < b1) x++;
                    else {
                        b1--;
                        y++;
                        dir = 2;
                    }
                    break;
                case 2:
                    if (y < b2) y++;
                    else {
                        b2--;
                        x--;
                        dir = 3;
                    }
                    break;
                case 3:
                    if (x > b3) x--;
                    else {
                        b3++;
                        y--;
                        dir = 4;
                    }
                    break;
                case 4:
                    if (y > b4) y--;
                    else {
                        b4++;
                        x++;
                        dir = 1;
                    }
                    break;
                default:
                    break;
            }
        }
        return ans;
    }
}
