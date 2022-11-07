package LeetCode.Medium;

import DataStructure.TreeNode;
import org.junit.Test;

import java.util.*;

public class LC_662_mark {
    /*
     * �������Ĳ��������null�ڵ���Ҫ���
     * ��ʱ
     * ���������ȫ�����������������»�ʹ�����Ľڵ���ɾ޴����
     * */
    public int widthOfBinaryTree1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cur = 1, max = 1, next = 1;
        boolean gen = root.left != null || root.right != null;
        while (gen) {
            gen = false;
            next = cur;
            while (cur-- > 0) {
                TreeNode first = queue.removeFirst();
                if (first.left != null || first.right != null) {
                    gen = true;
                }
                queue.addLast(Objects.requireNonNullElseGet(first.left, () -> new TreeNode(200)));
                queue.addLast(Objects.requireNonNullElseGet(first.right, () -> new TreeNode(200)));
            }
            cur = next * 2;
            if (gen) {
                max = Math.max(max, analyseQueue(queue));
            }
        }
        return max;
    }

    private int analyseQueue(LinkedList<TreeNode> queue) {
        if (queue.size() == 0) {
            return 0;
        }
        int l = -1, r = -1, count = -1;
        for (TreeNode treeNode : queue) {
            count++;
            int val = treeNode.val;
            if (val != 200 && l == -1) {
                l = count;
                r = l;
            } else if (val != 200) {
                r = count;
            }
        }
        return r - l + 1;
    }

    Map<Integer, Integer> map = new HashMap<>();
    int ans = 0;

    /*
     * dfs   >>>>>>>>>>�������ı�Ź���<<<<<<<<
     * ���ö������ı�Ź���:һ���ڵ�ı��Ϊn������ڵ�ı��Ϊn<<1���ҽڵ�ı��Ϊn<<1 + 1��n<<1|1
     * �ù�ϣ���¼ÿ������µĽڵ��Ӧ�����
     * dfs��һ�������ı�������ߵĽڵ㣬��һ��������ʱ������˺�ÿ�αȽϼ���
     * ʱ��ռ临�ӶȽ�Ϊn
     * */
    public int widthOfBinaryTree2(TreeNode root) {
        dfs(root, 1, 0);
        return ans;
    }

    private void dfs(TreeNode root, int index, int depth) {
        if (root != null) {
            if (!map.containsKey(depth)) {
                map.put(depth, index);
            }
            ans = Math.max(index - map.get(depth) + 1, ans);
            dfs(root.left, index << 1, depth + 1);
            dfs(root.right, index << 1 | 1, depth + 1);
        }
    }

    /*
     * ���ö�������Ž��в������
     * �˽��˶������ı�Ź�����ͺܼ�
     * */
    public int widthOfBinaryTree3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<IndexNode> q = new LinkedList<>();
        q.add(new IndexNode(root, 1));
        int max = 1, l, cur = 1, next = 0;
        while (cur > 0) {
            l = 0;
            while (cur-- > 0) {
                IndexNode first = q.removeFirst();
                if (l == 0) {
                    l = first.index;
                }
                max = Math.max(max, first.index - l + 1);
                if (first.node.left != null) {
                    next++;
                    q.addLast(new IndexNode(first.node.left, first.index << 1));
                }
                if (first.node.right != null) {
                    next++;
                    q.addLast(new IndexNode(first.node.right, first.index << 1 | 1));
                }
            }
            cur = next;
            next = 0;
        }
        return max;
    }

    private static class IndexNode {
        TreeNode node;
        int index;

        public IndexNode(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    @Test
    public void s() {
        int i = widthOfBinaryTree3(TreeNode.formTree("[0,0,0,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null]"));
        System.out.println("i = " + i);
    }
}
