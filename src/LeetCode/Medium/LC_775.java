package LeetCode.Medium;

public class LC_775 {
    /*
     * ���е�����Զ������������
     * */
    public boolean isIdealPermutation(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == i + 1) {
                if (nums[i + 1] == i) {
                    i++;
                } else return false;
            } else if (nums[i] != i) return false;
        }
        return true;
    }
}
