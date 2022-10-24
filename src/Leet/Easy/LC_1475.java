package Leet.Easy;

import java.util.LinkedList;

public class LC_1475 {
    /*
     * 暴力法，n^2
     * */
    public int[] finalPrices1(int[] prices) {
        int[] ans = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int discount = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    discount = prices[j];
                    break;
                }
            }
            ans[i] = prices[i] - discount;
        }
        return ans;
    }

    /*
     * 单调栈，存储下标
     * 由栈底至栈顶递增，如果新加入的小于栈顶元素，说明栈顶元素对应的找到可以打折的了
     * 时间复杂度n
     * 由于数据量太小，提交测试反而比暴力法慢
     * */
    public int[] finalPrices2(int[] prices) {
        int[] ans = new int[prices.length];
        LinkedList<Integer> s = new LinkedList<>();
        for (int i = 0; i < prices.length; i++) {
            while (s.size() > 0 && prices[i] <= prices[s.getLast()]) {
                ans[s.removeLast()] -= prices[i];
            }
            s.addLast(i);
            ans[i] = prices[i];
        }
        return ans;
    }
}
