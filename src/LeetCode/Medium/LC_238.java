package LeetCode.Medium;

public class LC_238 {
    /*
     * �ռ临�Ӷ�Ϊn��ʱ�临�Ӷ�Ϊn����ʹ�ó���
     * ά��һ��ǰ׺�����һ����׺����
     * */
    public int[] productExceptSelf1(int[] nums) {
        int[] pre = new int[nums.length], suf = new int[nums.length];
        pre[0] = 1;
        suf[suf.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
            suf[suf.length - i - 1] = suf[suf.length - i] * nums[suf.length - i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = pre[i] * suf[i];
        }
        return nums;
    }

    /*
     * �����ռ临�Ӷȣ������飬�ȼ�¼ǰ׺���ټ�¼��׺
     * */
    public int[] productExceptSelf2(int[] nums) {
        int[] ans = new int[nums.length];
        int cur = 1;
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            cur *= nums[i - 1];
            ans[i] = cur;

        }
        cur = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            cur *= nums[i + 1];
            ans[i] *= cur;
        }
        return ans;
    }
}
