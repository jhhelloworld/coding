package chapter_2_listproblem_self;

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

	// need n extra space
	public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        while (head!=null){
            if (stack.pop().value!=head.value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome2(Node head) {
        if(head==null ||head.next==null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node cur = slow.next;
        Stack<Node> stack = new Stack<>();
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.empty()){
            if(stack.pop().value!=head.value){
                return false;
            }
            head = head.next;
        }
        return true;
    }



    public static boolean isPalindrome3(Node head) {
        if(head == null || head.next == null) {
            return true;
        }
        //获取中间节点
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node right2 = fast;
        Node left2 = slow.next;
        Node right1 = slow;
        //翻转链表
        Node pre = right1;
        Node next = null;
        Node cur = left2;
        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        boolean res = true;
        Node cur1 = head;
        cur = pre;
        while (cur1!=null && cur!=null ){
            if(cur1.value != cur.value){
                res = false;
                break;
            }
            cur1 = cur1.next;
            cur = cur.next;
        }

        //恢复
        pre = null;
        next = null;
        cur = right2;
        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        right1.next = pre;



        return res;

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
        System.out.print(isPalindrome3(head) + " | ");
        System.out.print(isPalindrome3(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome3(head) + " | ");
        System.out.print(isPalindrome3(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome3(head) + " | ");
        System.out.print(isPalindrome3(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome3(head) + " | ");
        System.out.print(isPalindrome3(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome3(head) + " | ");
        System.out.print(isPalindrome3(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome3(head) + " | ");
        System.out.print(isPalindrome3(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome3(head) + " | ");
        System.out.print(isPalindrome3(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome3(head) + " | ");
        System.out.print(isPalindrome3(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome3(head) + " | ");
        System.out.print(isPalindrome3(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }

}