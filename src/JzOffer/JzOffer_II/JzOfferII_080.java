package JzOffer.JzOffer_II;

import java.util.ArrayList;
import java.util.List;

public class JzOfferII_080 {
    /*
     * 递归
     * */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        doCombine(ans, new ArrayList<>(), 0, n, k);
        return ans;
    }

    /**
     * @param ans  最终结果
     * @param list 临时集合
     * @param min  当前最大值
     * @param n    取值上限
     * @param len  个数上限
     */
    private void doCombine(List<List<Integer>> ans, List<Integer> list, int min, int n, int len) {
        if (list.size() == len) ans.add(List.copyOf(list));
        else if (min < n) {
            for (int i = min + 1; i <= n; i++) {
                list.add(i);
                doCombine(ans, list, i, n, len);
                list.remove(list.size() - 1);
            }
        }
    }
}
