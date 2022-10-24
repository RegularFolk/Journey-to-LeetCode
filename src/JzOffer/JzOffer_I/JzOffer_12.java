package JzOffer.JzOffer_I;

public class JzOffer_12 {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        int len = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {//以任意一个点作为起点
                if (path(board, row, col, word, len, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean path(char[][] board, int row, int col, String word, int len, boolean[][] visited) {
        if (len == word.length()) {//注意这里是 word.length 而不是 word.length - 1
            return true;
        }
        boolean hasPath = false;
        if (col >= 0 && row >= 0 && col < board[0].length && row < board.length && !visited[row][col] && board[row][col] == word.charAt(len)) {//判断当前格子是否有效
            len++;
            visited[row][col] = true;
            hasPath = path(board, row + 1, col, word, len, visited)
                    || path(board, row - 1, col, word, len, visited)
                    || path(board, row, col + 1, word, len, visited)
                    || path(board, row, col - 1, word, len, visited);
            if (!hasPath) {
                --len;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }
}
