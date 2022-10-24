package Leet.Easy;

import java.util.LinkedList;

public class LC_1475 {
    /*
     * ��������n^2
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
     * ����ջ���洢�±�
     * ��ջ����ջ������������¼����С��ջ��Ԫ�أ�˵��ջ��Ԫ�ض�Ӧ���ҵ����Դ��۵���
     * ʱ�临�Ӷ�n
     * ����������̫С���ύ���Է����ȱ�������
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
