package CrackCodeInterview.XVII_Hard;

public class Interview_17_04 {
    /*
     * ԭ�ع�ϣ
     * �������õȲ�������͹�ʽ
     * */
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int totalSum = (len * (len + 1)) >> 1, sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return totalSum - sum;
    }
}
