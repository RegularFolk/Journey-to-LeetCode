package LeetCode.Medium;

public class LC_795 {
    /*
    * ���Ԫ��������ڵ���LС�ڵ���R����������� = ���Ԫ��С�ڵ���R����������� - ���Ԫ��С��L�����������
    * */
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    private int count(int[] nums, int tar) {
        int ans = 0, count = 0;
        for (int num : nums) {
            if (num <= tar) ans += ++count;
            else count = 0;
        }
        return ans;
    }
}
