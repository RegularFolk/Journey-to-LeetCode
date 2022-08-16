package JzOffer;

public class JzOffer_56_1 {
    public int[] singleNumbers(int[] nums) {
        int resExclusiveOR = 0;
        for (int num : nums) {
            resExclusiveOR ^= num;
        }
        int std = findFirst1(resExclusiveOR);
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if (isBit1(num, std)) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }

    private int findFirst1(int resExclusiveOR) {
        int ans = 0;
        while ((resExclusiveOR & 1) == 0 && resExclusiveOR > 0) {
            resExclusiveOR >>= 1;
            ans++;
        }
        return ans;
    }

    boolean isBit1(int num, int resExclusiveOR) {
        num >>= resExclusiveOR;
        return (num & 1) == 1;
    }
}
