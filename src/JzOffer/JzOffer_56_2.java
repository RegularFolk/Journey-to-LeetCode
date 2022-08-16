package JzOffer;

public class JzOffer_56_2 {
    public int singleNumber(int[] nums) {
        int[] bitSum = new int[32]; //统计每一位上1出现了几次
        for (int num : nums) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                if ((num & bitMask) != 0) {
                    bitSum[j]++;
                }
                bitMask <<= 1;
            }
        }
        int ans = 0;
        for (int i : bitSum) {
            ans <<= 1;
            ans += i % 3;
        }
        return ans;
    }
}
