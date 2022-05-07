package Easy;

public class LC_237 {
    public static void main(String[] args) {
        //ÄæÌìÌâ
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
