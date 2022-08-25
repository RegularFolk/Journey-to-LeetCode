package CrackCodeInterview.IV_Tree_Graph;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Interview_04_01 {
    @Test
    public void t() {
        boolean b = findWhetherExistsPath1(5, new int[][]{{0, 2}, {1, 3}, {1, 4}, {1, 3}, {2, 3}, {3, 4}}, 0, 4);
        System.out.println("b = " + b);
    }

    /*
     * 从尾开始搜索，找到符合target，就以这条边的头作为target再次搜索
     * */
    public boolean findWhetherExistsPath1(int n, int[][] graph, int start, int target) {
        if (start == target) return true;
        boolean ans = false;
        for (int[] entry : graph) {
            if (entry[1] == target) { //相当于从后往前搜索
                ans = findWhetherExistsPath1(n, graph, start, entry[0]);
            }
            if (ans) {
                return true;
            }
        }
        return false;
    }

    /*
     * 从头开始搜索,用set剪枝，超时
     * */
    public boolean findWhetherExistsPath2(int n, int[][] graph, int start, int target) {
        Set<Integer> set = new HashSet<>();//利用set剪枝,记录已确认无法抵达的start
        return dfs(graph, start, target, set);
    }

    private boolean dfs(int[][] graph, int start, int target, Set<Integer> set) {
        if (start == target) {
            return true;
        } else if (set.contains(start)) {
            return false;
        }
        boolean ans = false;
        for (int[] ints : graph) {
            if (ints[0] == start) {
                ans = dfs(graph, ints[1], target, set);
            }
            if (ans) {
                return true;
            }
        }
        set.add(start);
        return false;
    }
}
