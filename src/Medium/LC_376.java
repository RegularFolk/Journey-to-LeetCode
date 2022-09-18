package Medium;

public class LC_376 {
    /*
     * 贪心
     * 删除单调坡上的节点，留下的就是摆动序列
     * */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int curDiff = 0, preDiff = 0, ans = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                ans++;
                preDiff = curDiff;
            }
        }
        return ans;
    }
}
