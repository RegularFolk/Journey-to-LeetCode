package LeetCode.Easy;

public class LC_1668 {
    /*
     * 暴力法
     * */
    public int maxRepeating(String sequence, String word) {
        int ans = 0;
        char[] seq = sequence.toCharArray(), ws = word.toCharArray();
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == ws[0]) {
                int len = 0, curSeq = i, curW = 0;
                while (curSeq < seq.length && seq[curSeq] == ws[curW]) {
                    curSeq++;
                    curW = (curW + 1) % ws.length;
                    len++;
                }
                int count = len / ws.length;
                if (count > 1) i += (count - 1) * ws.length - 1;//小幅度优化
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
