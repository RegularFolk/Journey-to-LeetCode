package LeetCode.Medium;

public class LC_494 {
    /*
     * ���鳤��С�ڵ���20��һ�ۻ���
     * �����ޱȣ�ʱ�临�Ӷ�2^n
     * */
    private int ans = 0;

    public int findTargetSumWays1(int[] nums, int target) {
        roll(nums, target, 0, 0);
        return ans;
    }

    private void roll(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) ans++;
            return;
        }
        roll(nums, target, index + 1, sum + nums[index]);
        roll(nums, target, index + 1, sum - nums[index]);
    }

    /*
     * ��̬�滮����������
     * */
    public int findTargetSumWays2(int[] nums, int target) {
        return 0;
    }
}
