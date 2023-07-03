package JzOffer.JzOffer_II;

public class JzOfferII_062 {
    static class Trie {

        private static class node {
            node[] children = new node[26];
            boolean mark = false;//记录是否为结尾
        }

        node prime = new node();

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            char[] chars = word.toCharArray();
            node cur = prime;
            for (char c : chars) {
                int index = c - 'a';
                if (cur.children[index] == null) cur.children[index] = new node();
                cur = cur.children[index];
            }
            cur.mark = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            char[] chars = word.toCharArray();
            node cur = prime;
            for (char c : chars) {
                int index = c - 'a';
                if (cur.children[index] == null) return false;
                cur = cur.children[index];
            }
            return cur.mark;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            node cur = prime;
            for (char c : chars) {
                int index = c - 'a';
                if (cur.children[index] == null) return false;
                cur = cur.children[index];
            }
            return true;
        }
    }
}
