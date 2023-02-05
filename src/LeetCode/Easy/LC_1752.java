package LeetCode.Easy;

public class LC_1752 {
    /*
    * 将数组看做是环
    * */
    public boolean check(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) count++;
        }
        return count <= 1;
    }
}
