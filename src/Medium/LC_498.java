package Medium;

public class LC_498 {
    public int[] findDiagonalOrder(int[][] mat) { //模拟，判断拐弯方向
        int xl = mat[0].length, yl = mat.length, y = 0, x = 0, count = 0;
        boolean dir = false;
        int[] ans = new int[xl * yl];
        while (y < yl && x < xl) {
            if (dir) {  //斜着向上
                while (y < yl && x >= 0) {
                    ans[count++] = mat[y++][x--];
                }
                if (y >= yl) {//到达右边界
                    y = yl - 1;
                    x += 2;
                } else {  //到达上边界
                    x = 0;
                }
                dir = false;
            } else {  //斜着向下
                while (y >= 0 && x < xl) {
                    ans[count++] = mat[y--][x++];
                }
                if (x >= xl) {//到达下边界,往右转弯
                    y += 2;
                    x = xl - 1;
                } else { //到达左边界,向下转弯
                    y = 0;
                }
                dir = true;
            }
        }
        return ans;
    }
}
