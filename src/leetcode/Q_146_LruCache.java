package leetcode;

import java.util.HashMap;

/**
 * jh
 * 2019年09月04日  14：05
 *
 * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在O(1) 时间复杂度内完成这两种操作？
 *
 */
public class Q_146_LruCache {

    public static class Node<V> {
        public V value;
        public Node<V> next;
        public Node<V> last;

        public Node(V value) {
            this.value = value;
        }
    }


    public static class NodeDoubleLinkedList<V> {
        public Node<V> head;
        public Node<V> tail;

        public NodeDoubleLinkedList() {
            head = null;
            tail = null;
        }

        public void addNode(Node<V> node) {
            if (node == null) {
                return;
            }
            if (this.head == null) {
                this.head = node;
                this.tail = node;
            } else {
                tail.next = node;
                node.last = tail;
                tail = node;
            }
        }
        public Node<V> removeHead() {
            if (this.head == null) {
                return null;
            }
            Node<V> res = this.head;
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = res.next;
                res.next = null;
                this.head.last = null;
            }
            return res;
        }


        public void moveNodeToTail(Node<V> node) {
            if (node == this.tail) {
                return;
            }
            if (node == this.head) {
                this.head = node.next;
                this.head.last = null;
            } else {
                node.last.next = node.next;
                node.next.last = node.last;
            }
            this.tail.next = node;
            node.last = this.tail;
            node.next = null;
            this.tail = node;
        }


    }

    private HashMap<Integer, Node<Integer>> keyNodeMap;
    private HashMap<Node<Integer>, Integer> nodeKeyMap;
    private NodeDoubleLinkedList<Integer> nodeList;
    private int capacity;


    public Q_146_LruCache(int capacity) {
        if (capacity < 1) {
            throw new RuntimeException("capacity cannot less than 1");
        }
        this.capacity = capacity;
        this.keyNodeMap = new HashMap<>();
        this.nodeKeyMap = new HashMap<>();
        this.nodeList = new NodeDoubleLinkedList();
    }

    public int get(int key) {
        if (this.keyNodeMap.containsKey(key)) {
            Node<Integer> node = this.keyNodeMap.get(new Integer(key));
            this.nodeList.moveNodeToTail(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            //别忘了重新赋值
            node.value = value;
            this.nodeList.moveNodeToTail(node);
            return;
        } else {
            Node<Integer> node = new Node<Integer>(value);
            this.keyNodeMap.put(key, node);
            this.nodeKeyMap.put(node, key);
            this.nodeList.addNode(node);
            //别忘了判断size
            if (this.keyNodeMap.size() > capacity) {
                this.removeMostUnusedCache();
            }
        }
    }


    private void removeMostUnusedCache() {
        Node<Integer> node = this.nodeList.removeHead();
        int key = this.nodeKeyMap.get(node);
        this.nodeKeyMap.remove(node);
        this.keyNodeMap.remove(key);
    }
}