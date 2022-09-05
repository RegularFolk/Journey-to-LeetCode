package Medium;

public class LC_707 {
    /*
     * ´êÒ»¸öÁ´±í
     * */
    static class MyLinkedList {
        private static class node {
            node prev;
            node next;
            int val;
        }

        private int size;
        node head;
        node tail;

        public MyLinkedList() {
            size = 0;
            head = new node();
            tail = new node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            if (size > index && index >= 0) {
                node cursor = head;
                while (index-- > 0) {
                    cursor = cursor.next;
                }
                return cursor.next.val;
            }
            return -1;
        }

        public void addAtHead(int val) {
            node add = new node();
            add.val = val;
            add.next = head.next;
            add.prev = head;
            head.next.prev = add;
            head.next = add;
            size++;
        }

        public void addAtTail(int val) {
            node add = new node();
            add.val = val;
            add.prev = tail.prev;
            add.next = tail;
            tail.prev.next = add;
            tail.prev = add;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (size == index) addAtTail(val);
            else if (index == 0) addAtHead(val);
            else if (size > index && index > 0) {
                node cursor = head;
                while (index-- > 0) {
                    cursor = cursor.next;
                }
                node add = new node();
                add.val = val;
                add.prev = cursor;
                add.next = cursor.next;
                cursor.next.prev = add;
                cursor.next = add;
                size++;
            }
        }

        public void deleteAtIndex(int index) {
            if (size > index) {
                node cursor = head;
                while (index-- > 0) {
                    cursor = cursor.next;
                }
                cursor.next.next.prev = cursor;
                cursor.next = cursor.next.next;
                size--;
            }
        }
    }
}
