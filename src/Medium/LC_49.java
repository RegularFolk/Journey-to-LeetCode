package Medium;

import java.util.*;

public class LC_49 {
    Map<String, List<String>> map = new HashMap<>();

    /*
    * 利用排序后的数组作为key，维护散列表
    * */
    public List<List<String>> groupAnagrams(String[] strs) {
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            List<String> list = map.getOrDefault(sorted, null);
            if (list != null) {
                list.add(str);
            } else {
                list = new LinkedList<>();
                list.add(str);
                map.put(sorted, list);
            }
        }
        List<List<String>> ans = new LinkedList<>();
        Set<Map.Entry<String, List<String>>> entries = map.entrySet();
        for (Map.Entry<String, List<String>> entry : entries) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
