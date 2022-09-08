package Hard;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC_332 {
    /*
     * 图 DFS
     * 存在死胡同，需要结合回溯
     * 事先进行排序，确保最先找到的一定是字典序最小的
     * 用Used数组去重
     * */
    private boolean[] used;
    private final LinkedList<String> ans = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        String[][] tics = new String[tickets.size()][2];
        int index = 0;
        for (List<String> ticket : tickets) {
            tics[index][0] = ticket.get(0);
            tics[index][1] = ticket.get(1);
            index++;
        }
        Arrays.sort(tics, (a, b) -> {
            String a0 = a[0], a1 = a[1], b0 = b[0], b1 = b[1];
            if ("JFK".equals(a0) && !"JFK".equals(b0)) return -1;
            else if (!"JFK".equals(a0) && "JFK".equals(b0)) return 1;
            int com0 = a0.compareTo(b0), com1 = a1.compareTo(b1);
            return com0 == 0 ? com1 : com0;
        });
        used = new boolean[tickets.size()];
        ans.add("JFK");
        dfs(tics, "JFK", 0);
        return ans;
    }

    private boolean dfs(String[][] tickets, String from, int count) {
        if (count == tickets.length) return true;
        int index = 0;
        String to;
        for (String[] ticket : tickets) {
            String head = ticket[0], tail = ticket[1];
            if (!used[index] && from.equals(head)) {
                to = tail;
                used[index] = true;
                ans.addLast(to);
                boolean dfs = dfs(tickets, to, count + 1);
                if (dfs) return true;
                used[index] = false;
                ans.removeLast();
            }
            index++;
        }
        return false;
    }

    @Test
    public void x() {
        List<String> itinerary = findItinerary(List.of(List.of("JFK", "KUL"), List.of("JFK", "NRT"), List.of("NRT", "JFK")));
        System.out.println(itinerary.toString());
    }
}
