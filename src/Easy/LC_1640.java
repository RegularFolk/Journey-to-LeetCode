package Easy;

public class LC_1640 {
    /*
     * É¢ÁÐ±í
     * */
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] rec = new int[101];
        for (int i = 0; i < arr.length; i++) {
            rec[arr[i]] = i;
        }
        for (int[] piece : pieces) {
            int start = rec[piece[0]], i = 0;
            while (i < piece.length && start + i < arr.length) {
                if (arr[start + i] != piece[i]) return false;
                i++;
                if (start + i == arr.length && i < piece.length) return false;
            }
        }
        return true;
    }
}
