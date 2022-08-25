package CrackCodeInterview.XVI_Medium;

import java.util.HashMap;

public class Interview_16_02 {
    /*
     * 利用散列表
     * */
    static class WordsFrequency {
        HashMap<String, Integer> map = new HashMap<>();

        public WordsFrequency(String[] book) {
            for (String s : book) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        public int get(String word) {
            return map.getOrDefault(word, 0);
        }
    }
}
