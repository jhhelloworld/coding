package chapter_2_listproblem_self;

import java.util.Currency;
import java.util.Stack;

/**
 * @author Jianghua
 * 2018年10月18日  21：53
 */
public class Problem_07_IsPalindromeList {

    public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}







    // need O(1) extra space
    public static boolean isPalindrome3(Node head) {
        if(head == null || head.next == null){
            return true;
        }
        boolean result = true;

        Node fast = head;
        Node middle = head;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            middle = middle.next;
        }
        Node rightBegin = middle.next;
        middle.next = null;
        Node pre = null;
        Node next = null;
        Node cur = rightBegin;
        while (cur !=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        Node cur1 = head;
        Node cur2 = pre;
        while (cur2 !=null){
            if(cur1.value != cur2.value){
                result = false;
                break;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        //recover
        cur = pre;
        pre = null;
        next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        middle.next = pre;

        return  result;

    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        //System.out.print(isPalindrome1(head) + " | ");
        //System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        //System.out.print(isPalindrome1(head) + " | ");
        //System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        //System.out.print(isPalindrome1(head) + " | ");
        //System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        //System.out.print(isPalindrome1(head) + " | ");
        //System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
       // System.out.print(isPalindrome1(head) + " | ");
        //System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        //System.out.print(isPalindrome1(head) + " | ");
       // System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        //System.out.print(isPalindrome1(head) + " | ");
        //System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        //System.out.print(isPalindrome1(head) + " | ");
       // System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        //System.out.print(isPalindrome1(head) + " | ");
        //System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }


}