package Leet.Easy;

public class LC_136 {
    /*
     * ����λ����
     * */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
