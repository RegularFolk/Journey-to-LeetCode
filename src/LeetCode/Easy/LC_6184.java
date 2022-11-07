package LeetCode.Easy;

import org.junit.Test;


public class LC_6184 {
    int[] months = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /*
    * 日期的计算
    * */
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int total = getDays(arriveAlice, leaveAlice) + getDays(arriveBob, leaveBob);
        String start = arriveAlice.compareTo(arriveBob) < 0 ? arriveAlice : arriveBob;
        String end = leaveAlice.compareTo(leaveBob) > 0 ? leaveAlice : leaveBob;
        return Math.max(0, total - getDays(start, end));
    }

    private int getDays(String date1, String date2) {
        int ans = 0;
        int mon1 = Integer.parseInt(date1.substring(0, 2));
        int mon2 = Integer.parseInt(date2.substring(0, 2));
        int day1 = Integer.parseInt(date1.substring(3));
        int day2 = Integer.parseInt(date2.substring(3));
        if (mon1 == mon2) return day2 - day1 + 1;
        ans += months[mon1] - day1 + 1;
        ans += day2;
        for (int i = mon1 + 1; i < mon2; i++) {
            ans += months[i];
        }
        return ans;
    }

    @Test
    public void x() {
        int i = countDaysTogether("10-20",
                "12-22",
                "06-21",
                "07-05");
        System.out.println(i);
    }
}
