package Medium;

public class LC_36 {
    /*
    * Hard LC_37µÄ¼ò»¯°æ
    * */
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.' && !qualified(board, row, col, board[row][col]))
                    return false;
            }
        }
        return true;
    }

    private boolean qualified(char[][] board, int row, int col, char in) {
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == in) return false;
            if (i != col && board[row][i] == in) return false;
        }
        int x = col / 3, y = row / 3;
        for (int i = 3 * x; i < 3 * x + 3; i++) {
            for (int j = 3 * y; j < 3 * y + 3; j++) {
                if (j != row && i != col && board[j][i] == in) return false;
            }
        }
        return true;
    }
}
