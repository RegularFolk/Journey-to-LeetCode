package LeetCode.Medium;

public class LC_208 {
    /*
     * 实现tire，比赛模板，效率低
     * */
    static class Trie {

        private int idx;  //idx是去掉复用节点一共插入了几个
        private final int[][] son;//用二维数组模拟树形结构。注意这个树的结构很特殊，树与树之间不是对齐的
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
    * 使用树形结构实现，效率更高
    * */
    static class TreeTrie {
        //树形tire
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
