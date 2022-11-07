package LeetCode.Medium;

public class LC_670 {
    /*
     * 贪心
     * 将开头与从后往前的最大值交换
     * */
    public int maximumSwap(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int pos = -1, max = -1;
            for (int j = chars.length - 1; j > i; j--) {
                if (chars[j] > chars[i] && chars[j] > max) {
                    max = chars[j];
                    pos = j;
                }
            }
            if (pos != -1) {
                chars[i] ^= chars[pos];
                chars[pos] ^= chars[i];
                chars[i] ^= chars[pos];
                return Integer.parseInt(new String(chars));
            }
        }
        return num;
    }
}
