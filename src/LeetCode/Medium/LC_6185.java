package LeetCode.Medium;

import java.util.Arrays;

public class LC_6185 {

    /*
    * Ì°ÐÄ+ÅÅÐò
    * */
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int pc = 0, tc = 0, ans = 0;
        while (pc < players.length && tc < trainers.length) {
            if (trainers[tc] >= players[pc]) {
                ans++;
                pc++;
            }
            tc++;
        }
        return ans;
    }
}
