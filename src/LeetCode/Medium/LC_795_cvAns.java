package LeetCode.Medium;

public class LC_795_cvAns {
    public static void main(String[] args) {
        System.out.println(numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
        //需要有整体的思想
    }

    public static int numSubarrayBoundedMax(int[] numbs, int left, int right) {
        return count(numbs, right) - count(numbs, left - 1);
    }

    public static int count(int[] numbs, int x) {
        int ans = 0;
        int count = 0;
        for (int i : numbs) {
            if (i <= x) {
                count++;
                ans += count;
            } else {
                count = 0;
            }
        }
        return ans;
    }
}
