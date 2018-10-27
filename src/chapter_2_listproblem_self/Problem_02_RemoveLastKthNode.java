package chapter_2_listproblem_self;

import java.awt.*;

/**
 * @author Jianghua
 * 2018年10月26日  19：40
 */
public class Problem_02_RemoveLastKthNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node removeLastKthNode(Node head, int lastKth) {
        if(head == null || lastKth<1){
            return null;
        }
        int i = 0;
        Node cur = head;
        Node pre = null;
        Node node = head;
        while (i<lastKth){
            cur = cur.next;
            i++;
        }
        while (cur != null){
            cur = cur.next;
            pre = node;
            node = node.next;

        }

        head = pre == null? head.next:head;
        if(pre !=null){
            pre.next = node.next;
        }
        return head;
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    public static DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
        if(head == null || lastKth<1){
            return null;
        }
        int i = 0;
        DoubleNode cur = head;
        DoubleNode pre = null;
        DoubleNode node = head;
        while (i<lastKth){
            cur = cur.next;
            i++;
        }
        while (cur != null){
            cur = cur.next;
            pre = node;
            node = node.next;
        }
        head = pre == null? head.next:head;
        head.last = null;
        if(pre !=null && node.next!=null){
            pre.next = node.next;
            node.next.last = pre;
        }else if(pre !=null && node.next==null){
            pre.next = null;
        }
        return head;

    }














    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }





    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        printLinkedList(head1);
        head1 = removeLastKthNode(head1, 3);
        // head1 = removeLastKthNode(head1, 6);
        // head1 = removeLastKthNode(head1, 7);
        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        head2.next.next.next.next = new DoubleNode(5);
        head2.next.next.next.next.last = head2.next.next.next;
        head2.next.next.next.next.next = new DoubleNode(6);
        head2.next.next.next.next.next.last = head2.next.next.next.next;
        printDoubleLinkedList(head2);
        head2 = removeLastKthNode(head2, 3);
        // head2 = removeLastKthNode(head2, 6);
        // head2 = removeLastKthNode(head2, 7);
        printDoubleLinkedList(head2);



    }
}







