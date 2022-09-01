package Medium;

public class LC_79 {
    /*
     * 回溯,利用visited数组剪枝
     * */
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        return dfsHelper(visited, board, word);
    }

    private boolean dfsHelper(boolean[][] visited, char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (dfs(visited, board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(boolean[][] visited, char[][] board, String word, int row, int col, int index) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && !visited[row][col] && board[row][col] == word.charAt(index)) {
            if (index == word.length() - 1) {
                return true;
            }
            visited[row][col] = true;
            boolean flag =
                    dfs(visited, board, word, row + 1, col, index + 1) ||
                    dfs(visited, board, word, row - 1, col, index + 1) ||
                    dfs(visited, board, word, row, col + 1, index + 1) ||
                    dfs(visited, board, word, row, col - 1, index + 1);
            if (flag) {
                return true;
            } else {
                visited[row][col] = false;
            }
        }
        return false;
    }
}
