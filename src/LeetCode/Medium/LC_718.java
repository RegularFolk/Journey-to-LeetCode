package LeetCode.Medium;

public class LC_718 {
    /*
     * 暴力法
     * 套三层循环
     * */
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int cnt = 0;
                while (i + cnt < nums1.length
                        && j + cnt < nums2.length
                        && nums1[i + cnt] == nums2[j + cnt]) cnt++;
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}
