package LeetCode.Easy;

public class LC_1598 {
    /*
     * ¼òµ¥Ä£ÄâÌâ
     * */
    public int minOperations(String[] logs) {
        int count = 0;
        for (String log : logs) {
            if (log.equals("../")) count = count > 0 ? count - 1 : 0;
            else if (!log.equals("./")) count++;
        }
        return Math.max(0, count);
    }
}
