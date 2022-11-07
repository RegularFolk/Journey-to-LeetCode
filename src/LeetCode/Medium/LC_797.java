package LeetCode.Medium;

import java.util.LinkedList;
import java.util.List;

public class LC_797 {
    /*
     * ͼ��
     * ���ݱ���
     * ��ֱ�ӵִ�n-1�ĵ�x,����ֱ�ӵִ�x�ĵ㣬�Դ����ƣ�ֱ���ҵ����0
     * */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(graph.length - 1);
        dfs(graph, list, graph.length - 1, path);
        return list;
    }

    private void dfs(int[][] graph, List<List<Integer>> ans, int target, LinkedList<Integer> path) {
        for (int i = 0; i < graph.length; i++) {
            if (i != target) {
                if (contains(graph[i], target)) {
                    path.addFirst(i);
                    if (i == 0) ans.add(List.copyOf(path));
                    else dfs(graph, ans, i, path);
                    path.removeFirst();
                }
            }
        }
    }

    private boolean contains(int[] ints, int target) {
        for (int anInt : ints) {
            if (target == anInt) return true;
        }
        return false;
    }
}
