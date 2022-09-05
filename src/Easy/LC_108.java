package Easy;

import DataStructure.TreeNode;

public class LC_108 {
    /*
     * 区间分治，每个节点都取现有范围的中间
     * */
    public TreeNode sortedArrayToBST(int[] nums) {
        return inorder(nums, 0, nums.length - 1);
    }

    private TreeNode inorder(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);
        int mid = (left + right) >> 1;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = inorder(nums, left, mid - 1);
        treeNode.right = inorder(nums, mid + 1, right);
        return treeNode;
    }

}
