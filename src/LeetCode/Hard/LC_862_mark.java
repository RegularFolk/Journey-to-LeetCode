package LeetCode.Hard;

import org.junit.Test;

import java.util.LinkedList;

public class LC_862_mark {
    /*
     * ǰ׺��+��������
     * ά��һ������������ǰ׺�͵�������
     * ����ǰ׺�����飬����ת�����������������������±��ӦԪ��֮����ڵ���k
     * ���õ���������ȥ���ת���������
     * ����ӵ�������ȶ�β��С��Ӧ�ò��ϵ�������Ϊ�����ʾ�±������ͬʱ��Сδ����������󣬸����׷�������
     * */
    public int shortestSubarray(int[] nums, int k) {
        long[] preSum = getPreSum(nums);
        int ans = Integer.MAX_VALUE;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        for (int i = 1; i < preSum.length; i++) {
            while (list.size() > 0 && preSum[list.getLast()] >= preSum[i]) list.removeLast();
            list.addLast(i);
            while (list.size() > 1 && preSum[list.getLast()] - preSum[list.getFirst()] >= k) {
                ans = Math.min(ans, list.getLast() - list.removeFirst());
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private long[] getPreSum(int[] nums) {
        long[] ans = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            ans[i + 1] = ans[i] + nums[i];
        }
        return ans;
    }

    @Test
    public void x() {
        int i = shortestSubarray(new int[]{56, -21, 56, 35, -9}, 61);
        System.out.println(i);
    }
}
