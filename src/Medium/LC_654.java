package Medium;

import DataStructure.TreeNode;

public class LC_654 {
    /*
     * 构建最大二叉树
     * */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) return null;
        int pos = findMax(nums, left, right);
        TreeNode root = new TreeNode(nums[pos]);
        root.left = build(nums, left, pos - 1);
        root.right = build(nums, pos + 1, right);
        return root;
    }

    private int findMax(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE, pos = -1;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                pos = i;
            }
        }
        return pos;
    }
}
