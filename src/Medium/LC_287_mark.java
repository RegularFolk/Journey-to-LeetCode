package Medium;

public class LC_287_mark {
    /*
     * 理解成循环链表
     * 将num[i]看成一个点i和从i指向num[i]的边，
     * 因为存在重复的元素，所以这个图存在环路
     * 抽象
     * */
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];//fast走两格
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
