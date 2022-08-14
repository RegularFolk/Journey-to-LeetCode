package JzOffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JzOffer_14 {
    public int cuttingRope(int n) {//贪心
        if (n <= 3) {
            return n - 1;
        } else {
            int round = n / 3, left = n % 3;
            if (left == 1) {
                return (int) Math.pow(3, round - 1) * 4;
            } else if (left == 2) {
                return (int) Math.pow(3, round) * 2;
            } else {
                return (int) Math.pow(3, round);
            }
        }
    }

    public int cuttingRope1(int n) { //贪心一行版
        return n <= 3 ? n - 1 : n % 3 == 1 ? (int) Math.pow(3, n / 3 - 1) * 4 : n % 3 == 2 ? (int) Math.pow(3, n / 3) * 2 : (int) Math.pow(3, n / 3);
    }

    public int cuttingRope2(int n) { //大数版,要不断取余，手动指数运算
        if (n <= 3) {
            return n - 1;
        } else {
            long ans = 1;
            while (n > 4) {
                ans *= 3;
                ans %= 1000000007;
                n -= 3;
            }
            return (int) (ans * n % 1000000007);
        }
    }

    public int cuttingRope3(int n) { //dp 从上往下分析，从下往上求解
        if (n <= 3) {
            return n - 1;
        }
        int[] store = new int[70];
        store[1] = 1;
        store[2] = 2;
        store[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, store[j] * store[i - j]);
            }
            store[i] = max;
        }
        return store[n];
    }

    @Test
    public void list() {
        /*
        * 对于ArrayList，普通的不指定位置的add会在末尾add，然后size加1，
        * 如果指定下标的add，会进行一个rangeCheck，小于等于size(逻辑大小)才可以操作，等于size时
        * 为紧挨着最后一个添加，小于为替换。
        *
        *
        * list里的元素必须是紧凑的，移除时如果移除中间则会将后面的全部往前移一格
        * 这与iterator契合
        *
        * */



        List<Integer> store = new ArrayList<>(70);
        store.add(1);
        store.add(2);
        store.add(3);
        store.add(3, 1);
        System.out.println("store.size() = " + store.size());
    }
}
