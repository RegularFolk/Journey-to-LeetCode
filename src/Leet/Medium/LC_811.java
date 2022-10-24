package Leet.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_811 {
    /*
     * É¢ÁÐ±í
     * */
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            int secondDot = cpdomain.lastIndexOf("."),
                    firstDot = cpdomain.indexOf("."),
                    blank = cpdomain.indexOf(" ");
            String firstDomain = cpdomain.substring(secondDot + 1);
            String secondDomain = cpdomain.substring(firstDot + 1);
            String thirdDomain = cpdomain.substring(blank + 1);
            int count = Integer.parseInt(cpdomain.substring(0, blank));
            map.put(firstDomain, map.getOrDefault(firstDomain, 0) + count);
            map.put(thirdDomain, map.getOrDefault(thirdDomain, 0) + count);
            if (firstDot != secondDot) map.put(secondDomain, map.getOrDefault(secondDomain, 0) + count);
        }
        List<String> ans = new ArrayList<>(map.size());
        map.forEach((key, value) -> ans.add(value + " " + key));
        return ans;
    }
}
