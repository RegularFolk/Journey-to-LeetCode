package DataStructure;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
    }

    public ListNode(ListNode next) {
        this.next = next;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 以LeetCode格式用字符串生成链表
     *
     * @param list 有效字符串
     * @return 字符串头结点
     */
    public static ListNode formLinkedList(String list) {
        if (list.length() == 2) {
            return null;
        }
        String substring = list.substring(1, list.length() - 1);
        String[] split = substring.split("[,]");
        ListNode dummy = new ListNode(), cursor = dummy;
        int count = 0;
        while (count < split.length) {
            cursor.next = new ListNode(Integer.parseInt(split[count++]));
            cursor = cursor.next;
        }
        return dummy.next;
    }
}
