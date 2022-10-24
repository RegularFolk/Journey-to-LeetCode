package JzOffer.JzOffer_I;

import org.junit.Test;

public class JzOffer_60 {
    @Test
    public void t() {
        double[] doubles = dicesProbability(2);
        for (double aDouble : doubles) {
            System.out.println("aDouble = " + aDouble);
        }
    }

    public double[] dicesProbability(int n) {   //耐心找规律，一定要冷静思考
        double total = Math.pow(6, n);
        int[] oldP = new int[7];
        for (int i = 1; i <= 6; i++) {
            oldP[i]++;
        }
        int[] newP = oldP;
        for (int i = 2; i <= n; i++) {  //骰子的个数
            newP = new int[i * 6 + 1];
            for (int j = 1; j <= 6; j++) {  //新骰子的点数
                int i_6 = 6 * i - 6;
                for (int k = i - 1; k <= i_6; k++) {
                    newP[k + j] += oldP[k];
                }
            }
            oldP = newP;
        }
        int n_5 = 5 * n + 1;
        double[] ans = new double[n_5];
        for (int i = n, count = 0; i <= 6 * n; i++, count++) {
            ans[count] = newP[i] / total;
        }
        return ans;
    }
}
