package JzOffer.JzOffer_I;


@SuppressWarnings("DuplicatedCode")
public class JzOffer_51 {

    /*
     * 归并排序的应用
     * */
    private static int ans = 0;

    public int reversePairs(int[] nums) {
        ans = 0;
        mergeSort(nums, new int[nums.length], 0, nums.length - 1);
        return ans;
    }

    private void mergeSort(int[] nums, int[] temp, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) >> 1;
        mergeSort(nums, temp, l, mid);
        mergeSort(nums, temp, mid + 1, r);
        int cur1 = l, cur2 = mid + 1, cur = l;
        while (cur1 <= mid && cur2 <= r) {
            if (nums[cur1] <= nums[cur2]) temp[cur++] = nums[cur1++];
            else {
                temp[cur++] = nums[cur2++];
                ans += mid - cur1 + 1;
            }
        }
        System.arraycopy(nums, cur1 <= mid ? cur1 : cur2, temp, cur, r - cur + 1);
        System.arraycopy(temp, l, nums, l, r - l + 1);
    }
}
