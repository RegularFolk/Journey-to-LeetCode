package CrackCodeInterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Interview_08_02 {
    /*
     * 回溯法
     *   即遍历所有可能的路径
     * 无情超时,时间复杂度为2^(x+y)
     *
     * 优化:改进travel方法，用set记录已访问过的无效点以剪枝(无效点:自该点起不论怎么走都到不了终点)
     *  将时间复杂度降为xy
     * 再改进，没必要用set，用一个等大小布尔数组即可（比set快10倍）
     * */
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        travel2(ans, obstacleGrid, 0, 0, new boolean[obstacleGrid.length][obstacleGrid[0].length]);
        return ans;
    }

    private boolean travel2(LinkedList<List<Integer>> ans, int[][] obstacleGrid, int x, int y, boolean[][] failed) {
        if (x < obstacleGrid[0].length && y < obstacleGrid.length && obstacleGrid[y][x] != 1 && !failed[y][x]) {
            List<Integer> location = new ArrayList<>();
            location.add(y);
            location.add(x);
            ans.addLast(location);
            if ((x == obstacleGrid[0].length - 1 && y == obstacleGrid.length - 1) ||
                    travel2(ans, obstacleGrid, x + 1, y, failed) || travel2(ans, obstacleGrid, x, y + 1, failed)) {
                return true;
            } else {
                ans.removeLast();
                failed[y][x] = true;
            }
        }
        return false;
    }

    private boolean travel1(LinkedList<List<Integer>> ans, int[][] obstacleGrid, int x, int y, HashSet<String> failed) {
        if (x < obstacleGrid[0].length && y < obstacleGrid.length && obstacleGrid[y][x] != 1 && !failed.contains(x + "," + y)) {
            List<Integer> location = new ArrayList<>();
            location.add(y);
            location.add(x);
            ans.addLast(location);
            if ((x == obstacleGrid[0].length - 1 && y == obstacleGrid.length - 1) ||
                    travel1(ans, obstacleGrid, x + 1, y, failed) || travel1(ans, obstacleGrid, x, y + 1, failed)) {
                return true;
            } else {
                ans.removeLast();
                failed.add(x + "," + y);
            }
        }
        return false;
    }

    private boolean travel(LinkedList<List<Integer>> ans, int[][] obstacleGrid, int x, int y) {
        if (x < obstacleGrid[0].length && y < obstacleGrid.length && obstacleGrid[y][x] != 1) {
            List<Integer> location = new ArrayList<>();
            location.add(y);
            location.add(x);
            ans.addLast(location);
            if ((x == obstacleGrid[0].length - 1 && y == obstacleGrid.length - 1) ||
                    travel(ans, obstacleGrid, x + 1, y) || travel(ans, obstacleGrid, x, y + 1)) {
                return true;
            } else {
                ans.removeLast();
            }
        }
        return false;
    }

}
