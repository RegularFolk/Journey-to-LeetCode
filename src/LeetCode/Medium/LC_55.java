package LeetCode.Medium;

public class LC_55 {
    /*
     * ��̬�滮
     * ģ����
     * �Ӻ���ǰ��ά��һ������Ŀ��Ե����յ�ĵ㣬
     * ��ÿ�����жϿɷ�ִ�����㣬�������������ĵ�
     * ������dp���鶼�����Ż���
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
