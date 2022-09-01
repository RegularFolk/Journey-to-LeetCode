package Medium;

public class LC_287_mark {
    /*
     * ����ѭ������
     * ��num[i]����һ����i�ʹ�iָ��num[i]�ıߣ�
     * ��Ϊ�����ظ���Ԫ�أ��������ͼ���ڻ�·
     * ����
     * */
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];//fast������
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
