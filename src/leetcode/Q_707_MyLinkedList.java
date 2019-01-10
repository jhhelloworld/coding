package leetcode;

import javax.swing.*;
import java.security.PublicKey;

/**
 * jh
 * 2019年01月08日  14：01
 * Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node,
 * and next is a pointer/reference to the next node. If you want to use the doubly linked list,
 * you will need one more attribute prev to indicate the previous node in the linked list.
 * Assume all nodes in the linked list are 0-indexed.
 * <p>
 * Implement these functions in your linked list class:
 * <p>
 * get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 * addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion,
 * the new node will be the first node of the linked list.
 * addAtTail(val) : Append a node of value val to the last element of the linked list.
 * addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list.
 * If index equals to the length of linked list, the node will be appended to the end of linked list.
 * If index is greater than the length, the node will not be inserted.
 * deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 * Example:
 * <p>
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
 * linkedList.get(1);            // returns 2
 * linkedList.deleteAtIndex(1);  // now the linked list is 1->3
 * linkedList.get(1);            // returns 3
 * Note:
 * <p>
 * All values will be in the range of [1, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in LinkedList library.
 */
public class Q_707_MyLinkedList {

    public static void main(String[] args) {
        Q_707_MyLinkedList linkedList = new Q_707_MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtIndex(1,2);
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(0));



    }
    /**
     * Initialize your data structure here.
     */
    public Q_707_MyLinkedList() {
    }

    class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;


    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index > size - 1 || index < 0) {
            return -1;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;

    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
            size++;
        }

    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        }
        if (index == 0) {
            this.addAtHead(val);
            return;
        }
        Node node = new Node(val);
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        Node next = cur.next;
        cur.next = node;
        node.next = next;
        if (next == null) {
            tail = node;
        }
        size++;


    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index > size - 1 || index < 0) {
            return;
        }
        if (index == 0) {
            head = head.next;
        }
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        if(cur.next == tail){
            tail = cur;

        }
        cur.next = cur.next.next;
        size--;




    }
}

class MyLinkedList {


}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 * ["MyLinkedList","addAtHead","addAtIndex","get","get","get"]
 * [[],[1],[1,2],[1],[0],[2]]
 *
 [null,null,null,-1,1,-1] *
 [null,null,null,2,1,-1] *
 */