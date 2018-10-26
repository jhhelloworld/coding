package chapter_2_listproblem_self;

import java.lang.reflect.WildcardType;

/**
 * @author Jianghua
 * 2018年10月26日  18：58
 */
public class Problem_20_RelocateLinkedList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void relocate(Node head) {
        if(head == null || head.next == null){
            return ;
        }
        Node mid = head;
        //todo
        Node right = head.next;
        while (right != null && right.next.next!=null){
            mid = mid.next;
            right = right.next.next;
        }
        right = mid.next;
        mid.next = null;
        mergeLR(head, right);

    }

    public static void mergeLR(Node left, Node right) {
        Node next = null;
        while (left!=null){
            next = right.next;
            left.next = right;
            right.next = null;
            right = next;
        }
        left.next  = right;
    }

}