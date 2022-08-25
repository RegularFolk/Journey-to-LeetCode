package CrackCodeInterview.IV_Tree_Graph;

import DataStructure.TreeNode;

public class Interview_04_02 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int mid = nums.length >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = form(nums, 0, mid - 1);
        root.right = form(nums, mid + 1, nums.length - 1);
        return root;
    }

    private TreeNode form(int[] nums, int left, int right) {
        if (right < left) {
            return null;
        }
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = form(nums, left, mid - 1);
        root.right = form(nums, mid + 1, right);
        return root;
    }
}
