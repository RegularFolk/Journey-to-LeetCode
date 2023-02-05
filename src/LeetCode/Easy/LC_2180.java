package LeetCode.Easy;

public class LC_2180 {
    /*
     * Ä£Äâ
     * */
    public int countEven(int num) {
        int ans = 0;
        for (int i = 1; i <= num; i++) if (qualified(i)) ans++;
        return ans;
    }

    private boolean qualified(int num) {
        int sum = 0;
        char[] chars = String.valueOf(num).toCharArray();
        for (char c : chars) sum += c - '0';
        return (sum & 1) == 0;
    }

}
