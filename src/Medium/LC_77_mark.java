package Medium;

import java.util.LinkedList;
import java.util.List;

public class LC_77_mark {
    /*
     * nextPermutation变种
     * 超级经典回溯算法
     * 运行流程:以n=10,k=5为例
     *  （取x，从y~10中取z个）
     *  (1,2,4)
     *      (2,3,3)
     *          (3,4,2)
     *              (4,5,1)
     *                  (5,6,0) 存入答案
     *                  (6,7,0) 存入答案
     *                     ......
     *                  (10,10,0) 存入答案
     *      (3,4,3)
     *          (4,5,2)
     *          ......
     * */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        nextPermutation(ans, new LinkedList<>(), 1, n, k);
        return ans;
    }

    /*
     * 从start到n，找k个
     * */
    private void nextPermutation(List<List<Integer>> ans, LinkedList<Integer> cur, int start, int n, int k) {
        if (k == 0) {
            ans.add((List<Integer>) cur.clone());
            return;
        }
        for (int j = start; j + k <= n + 1; j++) {//注意n+1小坑
            cur.addLast(j);
            nextPermutation(ans, cur, j + 1, n, k - 1);
            cur.removeLast();
        }
    }
}
