package Medium;

public class LC_794 {
    boolean complete1 = false;
    boolean complete2 = false;
    boolean ans = true;

    public boolean validTicTacToe(String[] board) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int temp = board[i].charAt(j);
                if (temp == 'X') {
                    count1++;
                } else if (temp == 'O') {
                    count2++;
                } else if (temp != ' ') {
                    return false;
                }
            }
        }
        if (count1 < count2 || count1 - count2 > 1) {
            return false;
        }
        for (int i = 0; i < 3; i++) {  //横着检查一遍
            if (!ans) {
                return false;
            }
            char ch1 = board[i].charAt(0);
            char ch2 = board[i].charAt(1);
            char ch3 = board[i].charAt(2);
            if (ch1 == ch2 && ch1 == ch3 && ch1 != ' ') {
                compare(ch1, ch2, count1, count2);
            }
        }
        for (int i = 0; i < 3; i++) {  //竖着检查一遍
            if (!ans) {
                return false;
            }
            char ch1 = board[0].charAt(i);
            char ch2 = board[1].charAt(i);
            char ch3 = board[2].charAt(i);
            if (ch1 == ch2 && ch1 == ch3 && ch1 != ' ') {
                compare(ch1, ch2, count1, count2);
            }
        }
        for (int i = 0; i < 2; i++) {
            if (!ans) {
                return false;
            }
            switch (i) {
                case 0 -> {
                    char ch1 = board[0].charAt(0);
                    char ch2 = board[1].charAt(1);
                    char ch3 = board[2].charAt(2);
                    if (ch1 == ch2 && ch1 == ch3 && ch1 != ' ') {
                        compare(ch1, ch2, count1, count2);
                    }
                }
                case 1 -> {
                    char ch1 = board[2].charAt(0);
                    char ch2 = board[1].charAt(1);
                    char ch3 = board[0].charAt(2);
                    if (ch1 == ch2 && ch1 == ch3 && ch1 != ' ') {
                        if (ch1 == 'X' && count1 > count2 && (!complete1 || count1 == 5) && !complete2) {
                            complete1 = true;
                        } else if (ch2 == 'O' && count1 == count2 && !complete1 && !complete2) {
                            complete2 = true;
                        } else {
                            return false;
                        }
                    }
                }
                default -> {
                }
            }
        }
        return true;
    }

    private void compare(char ch1, char ch2, int count1, int count2) {
        if (ch1 == 'X' && count1 > count2 && (!complete1 || count1 == 5) && !complete2) {
            complete1 = true;
        } else if (ch2 == 'O' && count1 == count2 && !complete1 && !complete2) {
            complete2 = true;
        } else {
            ans = false;
        }
    }
}
