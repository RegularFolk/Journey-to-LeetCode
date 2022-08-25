package CrackCodeInterview.VIII_DanymicPlanning;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Interview_08_12_mark {
    /*
     * 同 hard LC_51、LC_52
     * 很好的回溯题
     * */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        placeQueens(ans, new LinkedList<>(), 0, n, new boolean[n], new boolean[n], new boolean[n][n]);
        return ans;
    }

    private void placeQueens(List<List<String>> ans, LinkedList<String> curList, int currentY, int n, boolean[] visitedX, boolean[] visitedY, boolean[][] visited) {
        for (int i = 0; i < n; i++) {
            if (qualified(i, currentY, n, visitedX, visitedY, visited)) {
                visitedX[i] = true;
                visitedY[currentY] = true;
                visited[currentY][i] = true;
                String addString = ".".repeat(i) + "Q" + ".".repeat(n - i - 1);
                curList.addLast(addString);
                if (currentY == n - 1) {//只在终点添加到ans
                    ans.add((List<String>) curList.clone());
                } else {
                    placeQueens(ans, curList, currentY + 1, n, visitedX, visitedY, visited);
                }
                curList.removeLast();
                visitedX[i] = false;
                visitedY[currentY] = false;
                visited[currentY][i] = false;
            }
        }
    }

    public boolean qualified(int currentX, int currentY, int n, boolean[] visitedX, boolean[] visitedY, boolean[][] visited) {
        if (visitedX[currentX] || visitedY[currentY]) {
            return false;
        }
        //检查对角线
        int xCursor = currentX, yCursor = currentY;
        while (xCursor > 0 && yCursor > 0) {//左上
            if (visited[--yCursor][--xCursor]) {
                return false;
            }
        }
        xCursor = currentX;
        yCursor = currentY;
        while (xCursor < n - 1 && yCursor < n - 1) {//右下
            if (visited[++yCursor][++xCursor]) {
                return false;
            }
        }
        xCursor = currentX;
        yCursor = currentY;
        while (xCursor < n - 1 && yCursor > 0) {//右上
            if (visited[--yCursor][++xCursor]) {
                return false;
            }
        }
        xCursor = currentX;
        yCursor = currentY;
        while (xCursor > 0 && yCursor < n - 1) {//左下
            if (visited[++yCursor][--xCursor]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void t() {
        List<List<String>> lists = solveNQueens(9);
        System.out.println("lists.size() = " + lists.size());
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("================");
        }
    }

}
