package Medium;

public class LC_419 {
    public int countBattleships(char[][] board) {
        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    ans++;
                    if (j == board[0].length - 1 || board[i][j + 1] != 'X') {
                        if (i < board.length - 1) {
                            int k = i;
                            while (k < board.length && board[k][j] == 'X') {
                                board[k][j] = '.';
                                k++;
                            }
                        }
                    } else {
                        while (j < board[0].length - 1 && board[i][j] == 'X') {
                            board[i][j] = '.';
                            j++;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public int countBattleships2(char[][] board) {
        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
