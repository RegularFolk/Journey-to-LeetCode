package CrackCodeInterview.XVI_Medium;


public class Interview_16_11 {
    /*
     * 不用劳烦记忆化递归
     * 一般情况下，最短的就是全部shorter，第二短的是改一个为longer，以此类推最长的是全部longer
     * */
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[]{};
        if (shorter == longer) return new int[]{longer * k};
        int[] ans = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            ans[i] = shorter * (k - i) + longer * (i);
        }
        return ans;
    }

}
