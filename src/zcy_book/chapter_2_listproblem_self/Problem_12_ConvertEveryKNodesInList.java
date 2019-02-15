package zcy_book.chapter_2_listproblem_self;


import java.util.Stack;

/**
 * @author Jianghua
 * 2018年10月23日  19：43
 */
public class Problem_12_ConvertEveryKNodesInList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node reverseKNodes1(Node head, int K) {
        if(K<2){
            return head;
        }
        Node newHead = head;
        Node pre = null;
        Node next = null;
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        while (cur != null){
            next = cur.next;
            stack.push(cur);
            if(stack.size()==K){
                pre = resign1(stack,pre,next);
                newHead = head == newHead? cur:newHead;
            }
            //todo cur = cur.next;
            cur = next;
        }
        return newHead;


    }


    public static Node resign1(Stack<Node> stack, Node left, Node right){
        Node cur = stack.pop();
        if(left!=null){
            left.next = cur;
        }
        Node next = null;
        while (!stack.empty()){
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }



    public static Node reverseKNodes2(Node head, int K){
        if(K<2){
            return head;
        }
        Node pre = null;
        Node cur = head;
        Node next = null;
        Node start = null;
        int count = 1;
        while (cur!=null){
            next = cur.next;
            if(count == K){
                start = pre == null ? head:pre.next;
                head = pre == null? cur :head;
                resign2(pre,start,cur,next);
                pre = start;
                count = 0;
            }
            count++;

            cur = next;

        }

        return head;
    }


    public  static void resign2(Node left,Node start,Node end,Node right){
        Node pre = start;
        Node cur = start.next;
        Node next = null;
        while (cur != right){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if(left!=null){
            //todo left.next = pre;  也可
            left.next = end;
        }
        start.next =right;
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
        Node head = null;
        int K = 3;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        K = 3;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        K = 2;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        K = 3;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        K = 2;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        K = 3;
        printLinkedList(head);
        head = reverseKNodes1(head, K);
        printLinkedList(head);
        head = reverseKNodes2(head, K);
        printLinkedList(head);
        System.out.println("=======================");

    }
}