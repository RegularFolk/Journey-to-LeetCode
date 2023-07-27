package LeetCode.Easy;

public class LC_2500 {
    /*
     * ÿһ���ҳ�ÿһ�е����ֵ�����ֵ
     * ����Щ���ֵ�ۼ�
     * ģ����
     * */
    public int deleteGreatestValue(int[][] grid) {
        int ans = 0, round = grid[0].length;
        while (round-- > 0) {
            int[] candidate = new int[grid.length];
            for (int i = 0; i < grid.length; i++) {
                int[] arr = grid[i];
                int idx = 0, max = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] > max) {
                        max = arr[j];
                        idx = j;
                    }
                }
                arr[idx] = 0;
                candidate[i] = max;
            }
            int max = 0;
            for (int i : candidate) {
                max = Math.max(max, i);
            }
            ans += max;
        }
        return ans;
    }
}
