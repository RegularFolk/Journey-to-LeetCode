package Easy;

import java.util.Arrays;

public class LC_169 {
    public static void main(String[] args) {

    }

    public static int majorityElement(int[] numbs) {
        Arrays.sort(numbs);
        return numbs[(numbs.length - 1) / 2];
    }
}
