package JzOffer.JzOffer_II;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JzOfferII_083 {
    /*
     * »ØËÝ
     * */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> holder = new ArrayList<>();
        doPermutation(ans, holder, nums, 0);
        return ans;
    }

    private void doPermutation(List<List<Integer>> ans, List<Integer> holder, int[] nums, int idx) {
        if (holder.size() == nums.length) {
            ans.add(List.of(holder.toArray(new Integer[0])));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            holder.add(nums[idx]);
            doPermutation(ans, holder, nums, idx + 1);
            holder.remove(holder.size() - 1);
            swap(nums, idx, i);
        }
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

    public static void main(String[] args) {
        //System.out.println(String.valueOf(new BigInteger("10")));
        String s = String.valueOf(ByteBuffer.wrap(("¹Ø×¢").getBytes(StandardCharsets.UTF_8)).getChar());
        System.out.println(s);
        System.out.println(s.equals("aaa"));
    }
}
