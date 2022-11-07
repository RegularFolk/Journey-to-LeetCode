package AcWing.Chapter1;

import AcWing.util.AWUtils;

import java.util.*;

/*
    假定有一个无限长的数轴，数轴上每个坐标上的数都是 0。

    现在，我们首先进行 n 次操作，每次操作将某一位置 x 上的数加 c。

    接下来，进行 m 次询问，每个询问包含两个整数 l 和 r，你需要求出在区间 [l,r] 之间的所有数的和。

    输入格式
    第一行包含两个整数 n 和 m。

    接下来 n 行，每行包含两个整数 x 和 c。

    再接下来 m 行，每行包含两个整数 l 和 r。

    输出格式
    共 m 行，每行输出一个询问中所求的区间内数字和。

    数据范围
    ?109≤x≤109,
    1≤n,m≤105,
    ?109≤l≤r≤109,
    ?10000≤c≤10000
    输入样例：
    3 3
    1 2
    3 6
    7 5
    1 3
    4 6
    7 8
    输出样例：
    8
    0
    5
* */
public class AW_802 {
    /*
    * 离散化
    * 当数据值域很大，但是数据量相对较少时，可以将离散的数据按照大小顺序映射到另一个数组。
    * 查找时利用二分
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
    * 离散化，java处理离散化比较繁琐
    * */
    private static int[] sectionSum(int[][] input, int[][] queries) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] ints : input) {
            map.put(ints[0], map.getOrDefault(ints[0], 0) + ints[1]);
        }
        ArrayList<Map.Entry<Integer, Integer>> arrayList = new ArrayList<>(map.entrySet());
        Integer[] preSum = new Integer[arrayList.size()];
        preSum[0] = arrayList.get(0).getValue();
        for (int i = 1; i < preSum.length; i++) {//一边离散化一边变成前缀和数组
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
        //返回小于等于tar的最大值的下标，二分法
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
