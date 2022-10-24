package Leet.Easy;

public class LC_268 {
    public static void main(String[] args) {

    }

    public static int missingNumber(int[] numbs) {
        boolean flag = false;
        int cursor = 0;
        int temp;
        while (cursor < numbs.length) {
            if (numbs[cursor] == numbs.length) {
                if (!flag) {
                    flag = true;
                }
                cursor++;
            } else if (numbs[cursor] != cursor) {
                temp = numbs[numbs[cursor]];
                numbs[numbs[cursor]] = numbs[cursor];
                numbs[cursor] = temp;
            } else if (numbs[cursor] == cursor) {
                cursor++;
            }
        }
        if (!flag) {
            return numbs.length;
        } else {
            for (cursor = 0; cursor < numbs.length; cursor++) {
                if (numbs[cursor] != cursor) {
                    break;
                }
            }
        }
        return cursor;
    }
}
