package Leet.Easy;

public class LC_136 {
    /*
     * ¾­µäÎ»ÔËËã
     * */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
