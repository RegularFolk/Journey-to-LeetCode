package CrackCodeInterview.X_Sorting_Searching;

public class Interview_10_10 {
    /*
     * 实现一个二叉搜索树，多维护一个当前节点个数
     * */
    private static class StreamRank {

        private static class RankNode {
            public int value, count;//leftCount为这个节点有多少个左边子孙
            public RankNode left, right;

            public RankNode(int value) {
                this.value = value;
                count = 1;
            }
        }

        RankNode root = null;
        int count = 0;

        private RankNode insert(RankNode root, int x) {
            if (root == null) {
                return new RankNode(x);
            } else if (root.value == x) {
                root.count++;
            } else if (root.value < x) {
                root.right = insert(root.right, x);
            } else {
                root.left = insert(root.left, x);
            }
            return root;
        }

        public void track(int x) {
            if (root != null) {
                insert(root, x);
            } else {
                root = new RankNode(x);
            }
        }

        public int getRankOfNumber(int x) {
            if (root == null) {
                return 0;
            }
            count = 0;
            inOrder(root, x);
            return count;
        }

        private void inOrder(RankNode root, int x) {
            if (root != null) {
                inOrder(root.left, x);
                if (root.value == x) {
                    count += root.count;
                } else if (root.value < x) {
                    count += root.count;
                    inOrder(root.right, x);
                }
            }
        }
    }
}
