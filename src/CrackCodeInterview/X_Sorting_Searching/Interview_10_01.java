package CrackCodeInterview.X_Sorting_Searching;


public class Interview_10_01 {
    /*
     * 经典从尾部开始填
     * */
    public void merge(int[] A, int m, int[] B, int n) {
        int cursor = A.length - 1;
        m -= 1;
        n -= 1;
        while (m >= 0 && n >= 0) {
            A[cursor--] = Math.max(A[m], B[n]);
            if (A[m] > B[n]) {
                m--;
            } else {
                n--;
            }
        }//如果剩的是A就不用填
        while (n >= 0) {
            A[cursor--] = B[n--];
        }
    }
}
