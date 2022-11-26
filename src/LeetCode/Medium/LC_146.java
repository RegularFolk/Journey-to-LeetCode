package LeetCode.Medium;

import org.junit.Test;

import java.util.HashMap;

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
