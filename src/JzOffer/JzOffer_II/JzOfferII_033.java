package JzOffer.JzOffer_II;

import java.util.*;

public class JzOfferII_033 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            StringBuilder builder = new StringBuilder();
            for (char c : chars) {
                builder.append(c);
            }
            List<String> list = map.getOrDefault(builder.toString(), null);
            if (list == null) {
                list = new ArrayList<>();
                map.put(builder.toString(), list);
            }
            list.add(str);
        }
        map.forEach((k, v) -> {
            if (v != null) ans.add(v);
        });
        return ans;
    }
}
