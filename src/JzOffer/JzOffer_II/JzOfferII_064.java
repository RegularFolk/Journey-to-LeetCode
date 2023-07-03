package JzOffer.JzOffer_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JzOfferII_064 {
    /*
     * 直接暴力即可
     * */
    static class MagicDictionary {

        Map<Integer, List<String>> dic = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            for (String s : dictionary) {
                List<String> list = dic.get(s.length());
                if (list == null) list = new ArrayList<>();
                list.add(s);
                dic.put(s.length(), list);
            }
        }

        /*
         * 替换是必须的
         * 暴力匹配
         * */
        public boolean search(String searchWord) {
            boolean isModified;
            List<String> list = dic.get(searchWord.length());
            if (list == null) return false;
            char[] sc = searchWord.toCharArray();
            for (String s : list) {
                char[] chars = s.toCharArray();
                isModified = false;
                int i = 0;
                while (i < chars.length) {
                    if (chars[i] != sc[i] && !isModified) isModified = true;
                    else if (chars[i] != sc[i] && isModified) break;
                    i++;
                }
                if (i == chars.length && isModified) return true;
            }
            return false;
        }

    }

}
