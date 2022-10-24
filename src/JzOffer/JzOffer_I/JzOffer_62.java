package JzOffer.JzOffer_I;

import org.junit.Test;

import java.util.ArrayList;

public class JzOffer_62 {

    @Test
    public void t() {
        int i = lastRemaining1(5, 3);
        System.out.println("i = " + i);
    }

    public int lastRemaining1(int n, int m) {  //法一，循环模拟,超时
        if (n == 1) {
            return 0;
        }
        int[] ints = new int[n];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
        int left = n, count = m, cursor = 0;
        while (left > 1) {
            if (ints[cursor] != -1) {
                if (count == 1) {
                    ints[cursor] = -1;
                    left--;
                    count = m;
                } else {
                    count--;
                }
            }
            cursor = cursor == ints.length - 1 ? 0 : cursor + 1;
        }
        for (int anInt : ints) {
            if (anInt != -1) {
                return anInt;
            }
        }
        throw new RuntimeException();
    }

    public int lastRemaining2(int n, int m) {  //另一种模拟，勉强不超时
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    public int lastRemaining3(int n, int m) {  //数学方法
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
