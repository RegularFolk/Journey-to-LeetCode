package LeetCode.Easy;

public class LC_88 {
    public void merge(int[] numbs1, int m, int[] numbs2, int n) {  //从后往前
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

class redo_88 {
    /*
     * 从后往前放
     * */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int c1 = m - 1, c2 = n - 1, cur = nums1.length - 1;
        while (c1 >= 0 && c2 >= 0) {
            if (nums1[c1] >= nums2[c2]) {
                nums1[cur] = nums1[c1];
                c1--;
            } else {
                nums1[cur] = nums2[c2];
                c2--;
            }
            cur--;
        }
        int[] rest = c1 == -1 ? nums2 : nums1;
        int idx = c1 == -1 ? c2 : c1;
        while (idx >= 0) {
            nums1[cur--] = rest[idx--];
        }
    }
}
