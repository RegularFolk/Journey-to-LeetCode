package JzOffer.JzOffer_I;

public class JzOffer_66 {
    public int[] constructArr(int[] a) { //在i点把数组分为左右两部分,储存在另外两个数组中
        int[] left = new int[a.length], right = new int[a.length], ans = new int[a.length];
        for (int i = 0, cur = 1; i < left.length; i++) {
            left[i] = cur;
            cur *= a[i];
        }
        for (int i = right.length - 1, cur = 1; i >= 0; i--) {
            right[i] = cur;
            cur *= a[i];
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
