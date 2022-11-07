package LeetCode.Medium;

public class LC_55 {
    /*
     * 动态规划
     * 模板题
     * 从后往前，维护一个最近的可以到达终点的点，
     * 对每个点判断可否抵达这个点，可以则更新最近的点
     * 甚至连dp数组都可以优化掉
     * */
    public boolean canJump(int[] nums) {
        int closest = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= closest) {
                closest = i;
            }
        }
        return closest == 0;
    }
}
