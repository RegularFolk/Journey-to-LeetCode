package LeetCode.Medium;

public class LC_581 {
    /*
     * ̰��
     * �ҳ��м�һ����̵����������У�˵���������˶�������
     * ������ˣ�ÿ������һ�������ǵ�ǰ���������ֵ
     * �����Ҷˣ�ÿ������һ�������ǵ�ǰ��������Сֵ
     * �������������������ļ�Ϊ��
     * */
    public int findUnsortedSubarray(int[] nums) {
        int curMax = nums[0], curMin = nums[nums.length - 1];
        int left = 0, right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < curMax) right = i;
            else curMax = nums[i];
            if (nums[nums.length - i - 1] > curMin) left = nums.length - i - 1;
            else curMin = nums[nums.length - i - 1];
        }
        return right - left + 1;
    }
}
