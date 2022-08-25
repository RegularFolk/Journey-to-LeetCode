package CrackCodeInterview.VIII_DanymicPlanning;

import org.junit.Test;

public class Interview_08_11_mark {

    /*
     * 背包问题
     *   书本解法，过不了LeetCode
     * */
    public int waysToChange1(int n) {
        int[] denoms = {25, 10, 5, 1};
        int[][] map = new int[n + 1][denoms.length];
        return makeChange(n, denoms, 0, map);
    }

    private int makeChange(int amount, int[] denoms, int index, int[][] map) {
        if (map[amount][index] > 0) {
            return map[amount][index];
        }
        if (index >= denoms.length - 1) {
            return 1;
        }
        int denomAmount = denoms[index], ways = 0;
        for (int i = 0; i * denomAmount <= amount; i++) {
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange(amountRemaining, denoms, index + 1, map);
        }
        map[amount][index] = ways;
        return ways;
    }

    private final int[] coins = {25, 10, 5, 1};

    /*
     * 对于 coin in coins
     *  f(n)=f(n)+f(n-coin)
     *
     * 对四种面值依次计算，当排序末尾是25时，此时26的排列有f(26)+f(26-15=1),27的排列有f(27)+f(27-25=2)
     * 一次考虑一种coin，避免重复情况出现(关键)
     * */
    public int waysToChange2(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                res[i] = (res[i] + res[i - coin]) % 1000000007;
            }
        }
        return res[n];
    }

    @Test
    public void t() {
        System.out.println("waysToChange2() = " + waysToChange2(30));
    }
}
