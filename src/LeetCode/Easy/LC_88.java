package LeetCode.Easy;

public class LC_88 {
    public static void main(String[] args) {

    }

    public static void merge(int[] numbs1, int m, int[] numbs2, int n) {  //´ÓºóÍùÇ°
        if (m == 0) {
            System.arraycopy(numbs2, 0, numbs1, 0, numbs1.length);
        } else if (n != 0) {
            int cursor1 = m - 1;
            int cursor2 = n - 1;
            int put = m + n - 1;
            while (cursor2 >= 0) {
                if (cursor1 == -1 || numbs2[cursor2] >= numbs1[cursor1]) {
                    numbs1[put] = numbs2[cursor2];
                    cursor2--;
                } else {
                    numbs1[put] = numbs1[cursor1];
                    cursor1--;
                }
                put--;
            }
        }
    }
}
