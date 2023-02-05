package LeetCode.Easy;

public class LC_1796 {
    public int secondHighest(String s) {
        char[] chars = s.toCharArray();
        int max = -1, sub = -1;
        for (char c : chars) {
            int value = c - '0';
            if (value >= 0 && value <= 9) {
                if (value > max) {
                    sub = max;
                    max = value;
                } else if (value > sub && value != max) {
                    sub = value;
                }
            }
        }
        return sub;
    }
}
