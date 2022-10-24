package Leet.Medium;

public class LC_769 {
    /*
    * ģ��
    * */
    public int maxChunksToSorted(int[] arr) {
        int ans = 0, cursor = 0, max = arr[0];
        while (cursor < arr.length) {
            while (cursor <= max) {
                max = Math.max(arr[cursor], max);
                cursor++;
            }
            ans++;
            if (cursor < arr.length) max = arr[cursor];
        }
        return ans;
    }
}
