package LeetCode.Medium;

public class LC_208 {
    /*
     * ʵ��tire������ģ�壬Ч�ʵ�
     * */
    static class Trie {

        private int idx;  //idx��ȥ�����ýڵ�һ�������˼���
        private final int[][] son;//�ö�ά����ģ�����νṹ��ע��������Ľṹ�����⣬������֮�䲻�Ƕ����
        private final boolean[] cnt;

        public Trie() {
            idx = 0;
            int n = 100010;
            son = new int[n][26];
            cnt = new boolean[n];
        }

        public void insert(String word) {
            int last = 0;
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                int index = aChar - 'a';
                if (son[last][index] == 0) son[last][index] = ++idx;
                last = son[last][index];
            }
            cnt[last] = true;
        }

        public boolean search(String word) {
            int last = 0;
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                int index = aChar - 'a';
                if (son[last][index] == 0) return false;
                last = son[last][index];
            }
            return cnt[last];
        }

        public boolean startsWith(String prefix) {
            int last = 0;
            char[] chars = prefix.toCharArray();
            for (char aChar : chars) {
                int index = aChar - 'a';
                if (son[last][index] == 0) return false;
                last = son[last][index];
            }
            return true;
        }
    }

    /*
    * ʹ�����νṹʵ�֣�Ч�ʸ���
    * */
    static class TreeTrie {
        //����tire
        private static class Node {
            boolean isEnd;
            Node[] children;

            public Node() {
                isEnd = false;
                children = new Node[26];
            }
        }

        private final Node root;

        public TreeTrie() {
            root = new Node();
        }

        public void insert(String word) {
            char[] chars = word.toCharArray();
            Node last = root;
            for (char aChar : chars) {
                int index = aChar - 'a';
                if (last.children[index] == null) last.children[index] = new Node();
                last = last.children[index];
            }
            last.isEnd = true;
        }

        public boolean search(String word) {
            char[] chars = word.toCharArray();
            Node last = root;
            for (char aChar : chars) {
                int index = aChar - 'a';
                if (last.children[index] == null) return false;
                last = last.children[index];
            }
            return last.isEnd;
        }

        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            Node last = root;
            for (char aChar : chars) {
                int index = aChar - 'a';
                if (last.children[index] == null) return false;
                last = last.children[index];
            }
            return true;
        }
    }

}
