package CrackCodeInterview.VIII_DanymicPlanning;

import java.util.List;

public class Interview_08_06 {
    /*
    * 将n之前n-1个借C为中转移动到B
    * 再把第n个移动到C
    * 再把之前n-1个从B借A中转移动到C
    *
    * 大道至简
    * */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(n, A, B, C);
    }

    void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        move(n - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        move(n - 1, B, A, C);
    }
}
