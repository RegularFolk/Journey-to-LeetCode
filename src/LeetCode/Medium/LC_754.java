package LeetCode.Medium;

public class LC_754 {
    /*
     * 数学题
     * 首先target的正负性对题目无印象
     * 不断往右走，如果超过target，查看超过的数是否是偶数，如果是偶数则可以通过翻转前面一个正负号解决
     * 如果是奇数,则看当前已经走了几步了，如果当前走了偶数步，则下一步可以走奇数步，则可以通过翻转之前某个数回退到tar-(ans+1),多走一步抵达，
     * 如果当前走了奇数步，则下一步走偶数，需要多走两步
     * */
    public int reachNumber(int target) {
        if (target < 0) return reachNumber(Math.abs(target));
        int ans = 0, l = 0, r = target + 2;
        while (l <= r) {//找大于等于target的最小值
            int mid = (l + r) >> 1;
            long dis = ((long) (1 + mid) * (long) mid) >> 1;
            if (dis == target) return mid;
            else if (dis > target) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        int dis = (((1 + ans) * ans) >> 1) - target;
        return (dis & 1) == 0 ? ans : ans + ((ans & 1) == 0 ? 1 : 2);
    }

}
