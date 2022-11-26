package JzOffer.JzOffer_II;

public class JzOfferII_004 {
    /*
     * 位数统计
     *   记录所有数值的每一位共出现了多少次1，再对每一位进行mod 3，余下的组成便是只出现一次的数
     * 一次类推可以解决任意次数的同类题
     * */
    public int singleNumber(int[] nums) {
        int[] cnt = new int[32];
        int ans = 0;
        for (int num : nums) {
            for (int i = 0; i < cnt.length; i++) {
                cnt[i] += num & 1;
                num >>= 1;
            }
        }
        for (int i = 0; i < cnt.length; i++) {
            ans += ((cnt[i] % 3) & 1) << i;
        }
        return ans;
    }
}
