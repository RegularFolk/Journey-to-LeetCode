package Hard;

import java.util.LinkedList;
import java.util.List;

/**
 * 终于自力更生写出一道hard
 * 思路：
 *      先进行因数分解，拿到若干组因数，通过对因数的奇偶性判断是否是有效因数。
 *      由等差数列求和公式，将因数分类为 连续数的和 和 连续的个数 ，
 *      两者奇偶性必须相斥，于是将因数的其中一个乘二(因为求和公式里有除二)，若相斥则有效，ans加一
 */
public class LC_829 {
    public int consecutiveNumbersSum(int n) {
        if (n == 1) {
            return 1;
        }
        int ans = n % 2 == 1 ? 2 : 1;
        List<int[]> factor = new LinkedList<>();
        double sqrt = Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                factor.add(new int[]{i, n / i});
            }
        }
        if (factor.size() > 0) {
            for (int[] rec : factor) {
                int rec12 = rec[0] * 2, rec22 = rec[1] * 2;
                if (isOdd(rec12) ^ isOdd(rec[1])) {
                    ans++;
                }
                if (isOdd(rec22) ^ isOdd(rec[0]) && rec22 != rec12) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isOdd(int num) {
        return num % 2 == 1;
    }
}
