package Contest.LCCUP_2022;

import org.junit.Test;
import utils.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

public class NO_3 {
    /*
     * 从终点开始往外走
     * dir: 1上 2下 3左 4右
     * GG
     * 用例傻逼，究极情况下终点的数目比边上一圈还多，所以从边上一圈开始走不会超时，从终点反推反而会超时
     * */
    ArrayList<int[]> ans = new ArrayList<>();

    public int[][] ballGame(int num, String[] plate) {
        char[][] map = new char[plate.length][plate[0].length()];
        for (int i = 0; i < map.length; i++) {
            System.arraycopy(plate[i].toCharArray(), 0, map[i], 0, plate[i].length());
        }
        ArrayList<int[]> os = new ArrayList<>();
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] == 'O') os.add(new int[]{row, col});
            }
        }
        for (int[] o : os) {//往四个方向探索
            if (o[0] > 0)
                findPath(new int[]{o[0] - 1, o[1]}, 1, 0, num, map);
            if (o[0] < map.length - 1)
                findPath(new int[]{o[0] + 1, o[1]}, 2, 0, num, map);
            if (o[1] > 0)
                findPath(new int[]{o[0], o[1] - 1}, 3, 0, num, map);
            if (o[1] < map[0].length - 1)
                findPath(new int[]{o[0], o[1] + 1}, 4, 0, num, map);
        }
        return ans.toArray(int[][]::new);
    }

    private void findPath(int[] pos, int dir, int curStep, int limit, char[][] map) {
        if (isEdge(pos, map) && curStep <= limit) push(pos, dir);
        else if (check(pos, map) && map[pos[0]][pos[1]] != 'O') {
            curStep++;
            if (map[pos[0]][pos[1]] == '.') {//最简单的情况
                switch (dir) {
                    case 1 -> findPath(new int[]{pos[0] - 1, pos[1]}, 1, curStep, limit, map);
                    case 2 -> findPath(new int[]{pos[0] + 1, pos[1]}, 2, curStep, limit, map);
                    case 3 -> findPath(new int[]{pos[0], pos[1] - 1}, 3, curStep, limit, map);
                    case 4 -> findPath(new int[]{pos[0], pos[1] + 1}, 4, curStep, limit, map);
                }
            } else if (map[pos[0]][pos[1]] == 'W') {
                switch (dir) {
                    case 1 -> findPath(new int[]{pos[0], pos[1] + 1}, 4, curStep, limit, map);
                    case 2 -> findPath(new int[]{pos[0], pos[1] - 1}, 3, curStep, limit, map);
                    case 3 -> findPath(new int[]{pos[0] - 1, pos[1]}, 1, curStep, limit, map);
                    case 4 -> findPath(new int[]{pos[0] + 1, pos[1]}, 2, curStep, limit, map);
                }
            } else {
                switch (dir) {
                    case 1 -> findPath(new int[]{pos[0], pos[1] - 1}, 3, curStep, limit, map);
                    case 2 -> findPath(new int[]{pos[0], pos[1] + 1}, 4, curStep, limit, map);
                    case 3 -> findPath(new int[]{pos[0] + 1, pos[1]}, 2, curStep, limit, map);
                    case 4 -> findPath(new int[]{pos[0] - 1, pos[1]}, 1, curStep, limit, map);
                }
            }
        }
    }

    private boolean check(int[] pos, char[][] map) {
        return pos[0] >= 0 && pos[0] < map.length && pos[1] >= 0 && pos[1] < map[0].length;
    }

    private void push(int[] pos, int dir) {
        switch (dir) {
            case 1 -> ans.add(new int[]{pos[0] + 1, pos[1]});
            case 2 -> ans.add(new int[]{pos[0] - 1, pos[1]});
            case 3 -> ans.add(new int[]{pos[0], pos[1] + 1});
            case 4 -> ans.add(new int[]{pos[0], pos[1] - 1});
        }
    }

    private boolean isEdge(int[] pos, char[][] map) {
        return (pos[0] == -1 || pos[0] == map.length) && (pos[1] > 0 && pos[1] < map[0].length - 1) ||
                (pos[1] == -1 || pos[1] == map[0].length) && (pos[0] > 0 && pos[0] < map.length - 1);
    }

    @Test
    public void x() {
        int[][] ints = ballGame(41, new String[]{"E...W..WW", ".E...O...", "...WO...W", "..OWW.O..", ".W.WO.W.E", "O..O.W...", ".OO...W..", "..EW.WEE."});
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print("\t" + i);
            }
            System.out.println();
        }
    }
}
