package Leet.Medium;

import java.util.*;

public class LC_677 {
//逻辑正确，还可以改进
    public static void main(String[] args) {
        LC_677 l = new LC_677();
        l.insert("apple", 3);
        System.out.println(l.sum("ap"));
        l.insert("app", 2);
        l.insert("apple", 2);
        System.out.println(l.sum("ap"));
    }

    private Map<String, Integer> map;
    private Map<String, Set<String>> pre;

    public LC_677() {
        map = new HashMap<>();
        pre = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
        for (int i = 1; i <= key.length(); i++) {
            String sub = key.substring(0, i);
            Set<String> temp;
            if (pre.containsKey(sub)) {
                temp = pre.get(sub);
            } else {
                temp = new TreeSet<>();
            }
            temp.add(key);
            pre.put(sub, temp);
        }
    }

    public int sum(String prefix) {
        Set<String> strings = pre.keySet();
        Set<String> matched = null;
        int sum = 0;
        for (String s : strings) {
            if (s.equals(prefix)) {
                matched = pre.get(s);
                break;
            }
        }
        if (matched != null) {
            for (String s : matched) {
                sum += map.getOrDefault(s, 0);
            }
        }
        return sum;
    }
}
