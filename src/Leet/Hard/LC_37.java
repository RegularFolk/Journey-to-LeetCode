package Leet.Hard;

public class LC_37 {
    /*
     * 解数独
     * 究极暴力回溯
     * */
    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int row, int col) {
        if (col == 9) return dfs(board, row + 1, 0);
        if (row == 9) return true;
        if (board[row][col] != '.') return dfs(board, row, col + 1);
        for (char i = '1'; i <= '9'; i++) {
            if (qualified(board, row, col, i)) {
                board[row][col] = i;
                boolean next = dfs(board, row, col + 1);
                if (next) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    private boolean qualified(char[][] board, int row, int col, char in) {
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == in) return false;
            if (i != col && board[row][i] == in) return false;
        }
        int x = col / 3, y = row / 3;
        for (int i = 3 * x; i < 3 * x + 3; i++) {
            for (int j = 3 * y; j < 3 * y + 3; j++) {
                if (board[j][i] == in) return false;
            }
        }
        return true;
    }
}
