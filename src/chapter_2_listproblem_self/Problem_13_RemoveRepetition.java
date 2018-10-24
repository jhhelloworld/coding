package chapter_2_listproblem_self;

import java.util.HashSet;

/**
 * @author Jianghua
 * 2018年10月24日  16：38
 */
public class Problem_13_RemoveRepetition {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void removeRep1(Node head) {
        if(head == null){
            return;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        Node pre = head;
        Node cur = head.next;
        hashSet.add(head.value);
        while (cur!=null){
            if(hashSet.contains(cur.value)){
                pre.next = cur.next;
            }else {
                hashSet.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
    }


    public static void removeRep2(Node head) {
        if(head ==  null){
            return;
        }
        Node pre = null;
        Node next = null;
        Node cur = head;

        while (cur!=null){
            pre = cur;
            next = cur.next;
            while (next !=null){
                if(next.value == cur.value){
                    pre.next = next.next;
                }else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next.next = new Node(1);
        removeRep1(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next.next = new Node(1);
        removeRep2(head);
        printLinkedList(head);

    }

}












