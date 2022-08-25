package CrackCodeInterview.X_Sorting_Searching;

import java.util.*;

public class Interview_10_02 {
    /*
     * 一次遍历中完成
     * 对每个字符串排序，排序后检查是否存在与之相同的，若有则添加到ans
     * 利用集合对象的同一个引用的特性
     * N个字符串，字符串平均长度K，则时间复杂度为NKlogK
     * 击败100%
     * */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new LinkedList<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedS = new String(chars);
            List<String> mapValue = map.getOrDefault(sortedS, null);
            if (mapValue == null) {
                mapValue = new LinkedList<>();
                map.put(sortedS, mapValue);
                ans.add(mapValue);
            }
            mapValue.add(str);
        }
        return ans;
    }
}
