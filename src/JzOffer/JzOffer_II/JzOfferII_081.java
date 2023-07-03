package JzOffer.JzOffer_II;

import java.util.ArrayList;
import java.util.List;

public class JzOfferII_081 {

    /*
     * »ØËİ
     * */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        doCombine(ans, temp, candidates, target, 0, 0);
        return ans;
    }

    private void doCombine(List<List<Integer>> ans, List<Integer> temp, int[] candidates, int target, int cur, int sum) {
        if (sum == target) {
            ans.add(List.of(temp.toArray(Integer[]::new)));
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            if (candidates[i] + sum <= target) {
                temp.add(candidates[i]);
                doCombine(ans, temp, candidates, target, i, candidates[i] + sum);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
