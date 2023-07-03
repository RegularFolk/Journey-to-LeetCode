package JzOffer.JzOffer_II;

public class JzOfferII_066 {
    static class MapSum {
        /*
         * 递归+tire树
         * 暴力法就可以击败 100%
         * */
        private static class node {
            node[] children = new node[26];
            boolean mark = false;//是否是某个单词的末尾节点
            int val = 0;
        }

        private final node prime = new node();

        /**
         * Initialize your data structure here.
         */
        public MapSum() {

        }

        public void insert(String key, int val) {
            node cur = prime;
            char[] chars = key.toCharArray();
            for (char c : chars) {
                int index = c - 'a';
                if (cur.children[index] == null) cur.children[index] = new node();
                cur = cur.children[index];
            }
            cur.mark = true;
            cur.val = val;
        }

        public int sum(String prefix) {
            node start = getStart(prefix);
            return getSum(start);
        }

        private node getStart(String prefix) {
            node cur = prime;
            char[] chars = prefix.toCharArray();
            for (char c : chars) {
                int index = c - 'a';
                if (cur.children[index] == null) return null;
                cur = cur.children[index];
            }
            return cur;
        }

        private int getSum(node start) {
            if (start == null) return 0;
            int ans = start.val;
            for (node child : start.children) ans += getSum(child);
            return ans;
        }
    }
}
