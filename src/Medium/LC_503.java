package Medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class LC_503 {
    /*
     * 单调栈，栈顶为当前最大值下标
     * 开双倍大小的数组
     * */
    public int[] nextGreaterElements1(int[] nums) {
        int[] large = new int[nums.length * 2];
        System.arraycopy(nums, 0, large, 0, nums.length);
        System.arraycopy(nums, 0, large, nums.length, nums.length);
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(nums, -1);
        for (int i = 0; i < large.length; i++) {
            while (!stack.isEmpty() && large[stack.peek()] < large[i]) {
                Integer pop = stack.pop();
                int index = pop < nums.length ? pop : pop - nums.length;
                if (nums[index] == -1) {
                    nums[index] = large[i];
                }
            }
            stack.push(i);
        }
        return nums;
    }

    /*
     * 更优雅的开双倍的方法
     * */
    public int[] nextGreaterElements2(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        int len2 = nums.length * 2;
        for (int i = 0; i < len2; i++) {
            int num = nums[i % nums.length];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                ans[stack.pop()] = num;
            }
            if (i < nums.length) {//<<<<
                stack.push(i);
            }
        }
        return ans;
    }

    @Test
    public void s() {
        int[] ints = nextGreaterElements1(new int[]{1, 2, 3, 4, 3});
        System.out.println(Arrays.toString(ints));
    }
}
