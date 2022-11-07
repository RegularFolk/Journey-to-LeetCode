package LeetCode.Easy;

public class LC_1154 {
    public int dayOfYear(String date) {
        int ans = 0;
        date = date.replace('-', ':');
        String[] part = date.split(":");
        int[] mos = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((Integer.parseInt(part[0]) % 4 == 0 && Integer.parseInt(part[0]) % 100 != 0) || Integer.parseInt(part[0]) % 400 == 0) {
            mos[1]++;
        }
        int month = Integer.parseInt(part[1]);
        int day = Integer.parseInt(part[2]);
        for (int i = 0; i < month - 1; i++) {
            ans += mos[i];
        }
        return ans + day;
    }
}
