package AcWing.Chapter1;

import AcWing.util.AWUtils;

import java.util.*;

/*
    �ٶ���һ�����޳������ᣬ������ÿ�������ϵ������� 0��

    ���ڣ��������Ƚ��� n �β�����ÿ�β�����ĳһλ�� x �ϵ����� c��

    ������������ m ��ѯ�ʣ�ÿ��ѯ�ʰ����������� l �� r������Ҫ��������� [l,r] ֮����������ĺ͡�

    �����ʽ
    ��һ�а����������� n �� m��

    ������ n �У�ÿ�а����������� x �� c��

    �ٽ����� m �У�ÿ�а����������� l �� r��

    �����ʽ
    �� m �У�ÿ�����һ��ѯ������������������ֺ͡�

    ���ݷ�Χ
    ?109��x��109,
    1��n,m��105,
    ?109��l��r��109,
    ?10000��c��10000
    ����������
    3 3
    1 2
    3 6
    7 5
    1 3
    4 6
    7 8
    ���������
    8
    0
    5
* */
public class AW_802 {
    /*
    * ��ɢ��
    * ������ֵ��ܴ󣬵�����������Խ���ʱ�����Խ���ɢ�����ݰ��մ�С˳��ӳ�䵽��һ�����顣
    * ����ʱ���ö���
    * */
    public static void main(String[] args) {
        int[] ints = AWUtils.intsInput();
        int n = ints[0], m = ints[1];
        int[][] input = AWUtils.intsArrayInput(n);
        int[][] queries = AWUtils.intsArrayInput(m);
        int[] ans = sectionSum(input, queries);
        AWUtils.printArrayByLine(ans);
    }

    /*
    * ��ɢ����java������ɢ���ȽϷ���
    * */
    private static int[] sectionSum(int[][] input, int[][] queries) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] ints : input) {
            map.put(ints[0], map.getOrDefault(ints[0], 0) + ints[1]);
        }
        ArrayList<Map.Entry<Integer, Integer>> arrayList = new ArrayList<>(map.entrySet());
        Integer[] preSum = new Integer[arrayList.size()];
        preSum[0] = arrayList.get(0).getValue();
        for (int i = 1; i < preSum.length; i++) {//һ����ɢ��һ�߱��ǰ׺������
            preSum[i] = arrayList.get(i).getValue() + preSum[i - 1];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = doQuery(queries[i], preSum, arrayList);
        }
        return ans;
    }

    private static int doQuery(int[] query, Integer[] preSum, ArrayList<Map.Entry<Integer, Integer>> arrayList) {
        int l = ceil(arrayList, query[0] - 1);
        int r = ceil(arrayList, query[1]);
        return r == -1 ? 0 : (preSum[r] - (l == -1 ? 0 : preSum[l]));
    }

    private static int ceil(ArrayList<Map.Entry<Integer, Integer>> list, int tar) {
        //����С�ڵ���tar�����ֵ���±꣬���ַ�
        int l = 0, r = list.size() - 1, pos = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (list.get(mid).getKey() <= tar) {
                pos = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return pos;
    }
}
