package Leet.Hard;

import CrackCodeInterview.VIII_DanymicPlanning.Interview_08_12_mark;

public class LC_52 {
    private int ans = 0;

    public int totalNQueens(int n) {
        placeQueens(0, n, new boolean[n], new boolean[n], new boolean[n][n]);
        return ans;
    }

    private void placeQueens(int currentY, int n, boolean[] visitedX, boolean[] visitedY, boolean[][] visited) {
        for (int i = 0; i < n; i++) {
            if (qualified(i, currentY, n, visitedX, visitedY, visited)) {
                visitedX[i] = true;
                visitedY[currentY] = true;
                visited[currentY][i] = true;
                if (currentY == n - 1) {//只在终点添加到ans
                    ans++;
                } else {
                    placeQueens(currentY + 1, n, visitedX, visitedY, visited);
                }
                visitedX[i] = false;
                visitedY[currentY] = false;
                visited[currentY][i] = false;
            }
        }
    }

    private boolean qualified(int currentX, int currentY, int n, boolean[] visitedX, boolean[] visitedY, boolean[][] visited) {
        return new Interview_08_12_mark().qualified(currentX, currentY, n, visitedX, visitedY, visited);
    }
}
