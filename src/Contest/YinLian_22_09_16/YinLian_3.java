package Contest.YinLian_22_09_16;

public class YinLian_3 {
    /*
     * ‘ƒ∂¡Ã‚
     * */
    public int storedEnergy(int storeLimit, int[] power, int[][] supply) {
        int pc = 0, sc = 0, ans = 0;
        while (pc < power.length && sc < supply.length) {
            if (sc < supply.length - 1 && pc >= supply[sc + 1][0]) sc++;
            int max = supply[sc][2], min = supply[sc][1];
            if (power[pc] >= max) ans = Math.min(ans + power[pc] - max, storeLimit);
            else if (power[pc] <= min) ans = Math.max(0, ans - (min - power[pc]));
            pc++;
        }
        return ans;
    }
}
