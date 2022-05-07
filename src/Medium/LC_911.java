package Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LC_911 {

    private static class TopVotedCandidate {
        TreeMap<Integer, Integer> record = new TreeMap<>();//记录每一时刻领先的候选人
        Map<Integer, Integer> tickets = new HashMap<>();//记录每一个人的票数

        public TopVotedCandidate(int[] persons, int[] times) {
            int maxTic = -1; //最多的票数
            int maxNo = 0;
            int len = persons.length;
            for (int i = 0; i < len; i++) {
                tickets.put(persons[i], tickets.getOrDefault(persons[i], 0) + 1);  //当前得票的人的票数加1
                int currentTic = tickets.get(persons[i]);  //获取本次的票的人的票数
                if (currentTic >= maxTic) {         //与得票最多的人对比
                    record.put(times[i], persons[i]);
                    maxTic = currentTic;
                    maxNo = persons[i];
                } else {
                    record.put(times[i], maxNo);
                }
            }
        }

        public int q(int t) {
            return record.floorEntry(t).getValue();
        }
    }
}
