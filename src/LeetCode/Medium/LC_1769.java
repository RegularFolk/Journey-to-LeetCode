package LeetCode.Medium;

public class LC_1769 {
    /*
     * ±©Á¦·¨£¬N^2
     * */
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        char[] chars = boxes.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int l = 0; l < i; l++) {
                if (chars[l] == '1') ans[i] += i - l;
            }
            for (int r = i + 1; r < chars.length; r++) {
                if (chars[r] == '1') ans[i] += r - i;
            }
        }
        return ans;
    }

    /*
     * ×óÓÒ±éÀú£¬N
     * */
    public int[] minOperations1(String boxes) {
        int[] ans = new int[boxes.length()];
        char[] chars = boxes.toCharArray();
        int sum = 0, count = 0;
        for (int i = 1; i < ans.length; i++) {
            if (chars[i - 1] == '1') count++;
            sum += count;
            ans[i] += sum;
        }
        sum = 0;
        count = 0;
        for (int i = ans.length - 2; i >= 0; i--) {
            if (chars[i + 1] == '1') count++;
            sum += count;
            ans[i] += sum;
        }
        return ans;
    }
}
