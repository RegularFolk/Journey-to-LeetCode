package JzOffer.JzOffer_II;

import java.util.*;

public class JzOfferII_082 {

    /*
     * 与081极其类似
     * 考虑去重
     * */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> holder = new ArrayList<>();
        Arrays.sort(candidates);
        doCombine(ans, holder, candidates, target, 0, 0);
        return ans;
    }

    private void doCombine(List<List<Integer>> ans, List<Integer> holder, int[] candidates, int target, int idx, int sum) {
        if (sum == target) {
            ans.add(List.copyOf(holder));
            return;
        }
        for (int i = idx; i < candidates.length && candidates[i] + sum <= target; i++) {
            if (i == idx || candidates[i] != candidates[i - 1]) {
                holder.add(candidates[i]);
                doCombine(ans, holder, candidates, target, i + 1, sum + candidates[i]);
                holder.remove(holder.size() - 1);
            }
        }
    }

}
