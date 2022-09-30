package Medium;

import org.junit.Test;
import utils.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC_6190 {
    /*
     * Î¬»¤Ç°ºó×º
     * */
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if (k << 1 == nums.length) return ans;
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (!left.isEmpty() && left.getLast() < nums[i]) left.clear();
            left.addLast(nums[i]);
            if (!right.isEmpty() && right.getLast() > nums[i + k + 1]) right.clear();
            right.addLast(nums[i + k + 1]);
        }
        for (int i = k; i < nums.length - k; i++) {
            if (left.size() == right.size() && left.size() == k) {
                ans.add(i);
            }
            if (i < nums.length - k - 1) {
                if (left.size() == k) left.removeFirst();
                if (!left.isEmpty() && left.getLast() < nums[i]) left.clear();
                left.addLast(nums[i]);
                if (right.size() == k) right.removeFirst();
                if (!right.isEmpty() && right.getLast() > nums[i + k + 1]) right.clear();
                right.addLast(nums[i + k + 1]);
            }
        }
        return ans;
    }

    @Test
    public void x() {
        List<Integer> list = goodIndices(new int[]{693570, 409751, 33944, 16682, 26296, 545257, 827687, 885741, 970671}, 3);
        ArrayUtil.printList(list);
    }
}
