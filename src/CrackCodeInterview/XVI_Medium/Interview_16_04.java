package CrackCodeInterview.XVI_Medium;

public class Interview_16_04 {
    /*
     * 横着竖着斜着搜索
     * 就嗯搜
     * */
    public String tictactoe(String[] board) {
        boolean draw = true;
        String X = "X".repeat(board.length), O = "O".repeat(board.length);
        for (String s : board) {
            if (X.equals(s)) {
                return "X";
            } else if (O.equals(s)) {
                return "O";
            } else if (draw && s.contains(" ")) {
                draw = false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            String s = getCol(board, i);
            if (X.equals(s)) {
                return "X";
            } else if (O.equals(s)) {
                return "O";
            } else if (draw && s.contains(" ")) {
                draw = false;
            }
        }
        String s = getLeft(board);
        if (X.equals(s)) {
            return "X";
        } else if (O.equals(s)) {
            return "O";
        } else if (draw && s.contains(" ")) {
            draw = false;
        }
        s = getRight(board);
        if (X.equals(s)) {
            return "X";
        } else if (O.equals(s)) {
            return "O";
        } else if (draw && s.contains(" ")) {
            draw = false;
        }
        return draw ? "Draw" : "Pending";
    }

    private String getRight(String[] board) {
        StringBuilder builder = new StringBuilder(board.length);
        for (int i = 0; i < board.length; i++) {
            builder.append(board[i].charAt(board.length - i - 1));
        }
        return builder.toString();
    }

    private String getLeft(String[] board) {
        StringBuilder builder = new StringBuilder(board.length);
        for (int i = 0; i < board.length; i++) {
            builder.append(board[i].charAt(i));
        }
        return builder.toString();
    }

    private String getCol(String[] board, int i) {
        StringBuilder builder = new StringBuilder(board.length);
        for (String s : board) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}
