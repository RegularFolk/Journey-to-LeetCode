package LeetCode.Medium;

public class LC_11 {
    /*
     * ̰��+˫ָ��
     * ���������Ҷ˵����м���
     * */
    public int maxArea(int[] height) {
        int max = -1, l = 0, r = height.length - 1;
        while (l < r) {
            max = Math.max(Math.min(height[l], height[r]) * (r - l), max);
            if (height[l] >= height[r]) {
                r--;
            } else if (height[l] < height[r]) {
                l++;
            }
        }
        return max;
    }
}
