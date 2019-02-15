package zcy_book.chapter_2_listproblem_self;

/**
 * @author Jianghua
 * 2018年10月18日  19：26
 */
public class Problem_05_ReversePartList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node reversePart(Node head, int from, int to) {
        if(head == null || head.next == null ){
            return head;
        }
        Node cur = head;
        Node pre = null;
        Node pos = null;
        int len = 0;
        while (cur != null){
            len ++ ;
            pre = len == from -1 ?cur :pre;
            pos = len == to+1 ? cur :pos;
            cur = cur.next;
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }

        Node next = null;
        Node last = pre;
        cur = pre == null?head: pre.next;
        Node start = cur;
        while (cur != pos){
            next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        if(pre == null){
            return last;
        }
        pre.next = last;
        start.next = pos;
        return head;
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
        printLinkedList(head);
        head = reversePart(head, 1, 1);
        printLinkedList(head);

        head = new Node(1);
        printLinkedList(head);
        head = reversePart(head, 1, 1);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        head = reversePart(head, 1, 2);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        head = reversePart(head, 2, 3);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        head = reversePart(head, 1, 3);
        printLinkedList(head);

    }


}


























