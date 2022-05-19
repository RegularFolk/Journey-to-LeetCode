package Medium;

import java.util.ArrayList;
import java.util.List;

public class LC_442 {

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public static List<Integer> findDuplicates(int[] nums) { //利用交换来处理，将每个值换到值对应下标
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != 0) {
                int shouldBe = nums[i] - 1;
                if (nums[i] == nums[shouldBe]) break;
                int temp = nums[shouldBe];
                nums[shouldBe] = nums[i];
                nums[i] = temp;
                if (nums[shouldBe] == 0) {
                    nums[shouldBe] = nums[i];
                    nums[i] = 0;
                    break;
                }
            }
            if (nums[i] != i + 1 && nums[i] != 0) {
                ans.add(nums[i]);
                nums[i] = 0;
            }
        }
        return ans;
    }

    public static List<Integer> findDuplicates1(int[] nums) { //或者利用正负号来区分，复杂度和交换实际上是一样的，实际耗时也相同，但是代码更精简
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if (nums[abs - 1] > 0) {
                nums[abs - 1] *= -1;
            } else {
                ans.add(abs);
            }
        }
        return ans;
    }
}
