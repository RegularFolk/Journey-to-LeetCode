package JzOffer.JzOffer_II;

import java.util.List;

public class JzOfferII_063 {
    /*
     * 对字典建前缀树，将sentence中匹配上的用前缀替换
     * */
    private static class node {
        node[] children = new node[26];
        boolean mark = false;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        node root = buildTree(dictionary);
        String[] split = sentence.split("[ ]");
        for (int i = 0, splitLength = split.length; i < splitLength; i++) {
            String pre = getPrefix(root, split[i]);
            if (pre != null && !pre.equals("")) split[i] = pre;
        }
        return String.join(" ", split);
    }

    private String getPrefix(node root, String s) {
        StringBuilder builder = new StringBuilder();
        node cur = root;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            int index = c - 'a';
            cur = cur.children[index];
            builder.append(c);
            if (cur == null) return null;
            if (cur.mark) return builder.toString();
        }
        return null;
    }

    private node buildTree(List<String> dictionary) {
        node prime = new node();
        for (String s : dictionary) {
            node cur = prime;
            char[] chars = s.toCharArray();
            for (char c : chars) {
                int index = c - 'a';
                if (cur.children[index] == null) cur.children[index] = new node();
                cur = cur.children[index];
            }
            cur.mark = true;
        }
        return prime;
    }
}
