package JzOffer.JzOffer_II;

public class JzOfferII_068 {
    /*
     * ���ֲ���ģ����
     * */
    public int searchInsert(int[] nums, int target) {
        int ans = 0, left = 0, right = nums.length - 1;
        while (left <= right) {//ȡ�Ⱥ�
            ans = (left + right) >> 1;
            if (nums[ans] == target) return ans;
            else if (nums[ans] > target) right = ans - 1;
            else left = ans + 1;
        }
        return nums[ans] > target ? ans : ans + 1;
    }
}
