package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class LC_146 {

    /*
     * 实现LRU,散列表+双向链表
     * */
     public static class LRUCache {

        private static class node {
            node prev;
            node next;
            int key;
            int value;

            public node() {
            }

            public node(int value, int key) {
                this.value = value;
                this.key = key;
            }
        }

        int capacity;
        int size = 0;
        HashMap<Integer, node> map;
        node head = new node();
        node tail = new node();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            node node = map.getOrDefault(key, null);
            if (node != null) {
                moveToFirst(node);
                return node.value;
            }
            return -1;
        }

        private void moveToFirst(node node) {
            LRUCache.node nodePrev = node.prev, nodeNext = node.next;
            nodePrev.next = nodeNext;
            nodeNext.prev = nodePrev;
            LRUCache.node headNext = head.next;
            node.next = headNext;
            node.prev = head;
            headNext.prev = node;
            head.next = node;
        }

        public void put(int key, int value) {
            node mapValue = map.getOrDefault(key, null);
            if (mapValue != null) {
                mapValue.value = value;
                moveToFirst(mapValue);
            } else {
                mapValue = new node(value, key);
                map.put(key, mapValue);
                node headNext = head.next;
                mapValue.next = headNext;
                mapValue.prev = head;
                head.next = mapValue;
                headNext.prev = mapValue;
                size++;
            }
            if (size > capacity) removeLast();//修改链表
        }

        private void removeLast() {
            map.remove(tail.prev.key);
            node prev = tail.prev.prev;
            prev.next = tail;
            tail.prev = prev;
            size--;
        }
    }
}

class redo_146 {
    static class LRUCache {
        /*
         * LRU的处理思路
         * 用一个Map<Value,Node>和一个链表实现
         * */

        private final Node head;
        private final Node tail;
        private final int capacity;
        private final Map<Integer, Node> map;
        private int size;

        public LRUCache(int capacity) {
            head = new Node(0, 0, null, null);
            tail = new Node(0, 0, null, null);
            head.next = tail;
            tail.prev = head;
            map = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            move2Head(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.val = value;
                move2Head(node);
            } else {
                insert(new Node(key, value, null, null));
                if (size > capacity) {
                    removeLast();
                }
            }
        }

        private void insert(Node node) {
            map.put(node.key, node);
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
            size++;
        }

        private void move2Head(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
        }

        private void removeLast() {
            if (size > 0) {
                size--;
                map.remove(tail.prev.key);
                Node prev = tail.prev.prev;
                prev.next = tail;
                tail.prev = prev;
            }
        }

        private static class Node {
            int val;
            int key;
            Node prev;
            Node next;

            public Node(int key, int val, Node prev, Node next) {
                this.val = val;
                this.key = key;
                this.prev = prev;
                this.next = next;
            }
        }
    }
}
