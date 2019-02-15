package zcy_book.chapter_2_listproblem_self;

/**
 * @author Jianghua
 * 2018年10月23日  11：05
 */
public class Problem_10_AddTwoLinkedLists {


    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node addLists1(Node head1, Node head2) {
        return null;
    }

    public static Node addLists2(Node head1, Node head2) {
        head1 = reverseNodeList(head1);
        head2 = reverseNodeList(head2);

        int n1 = 0;
        int n2 = 0;
        int n = 0;
        int ca = 0;

        Node cur1 = head1;
        Node cur2 = head2;
        Node node = null;
        Node pre = null;

        while (cur1!=null || cur2 !=null){
            n1 =cur1 !=null?cur1.value:0;
            n2 = cur2 != null ? cur2.value : 0 ;
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n%10);
            node.next = pre;
            ca = n/10;
            cur1 = cur1!=null?cur1.next:null;
            cur2 = cur2!=null?cur2.next:null;
        }
        if(ca  == 1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        reverseNodeList(head1);
        reverseNodeList(head2);




        return node;
    }


    public static Node reverseNodeList(Node head){
        Node pre = null;
        Node next = null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
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
        Node head1 = new Node(9);
        head1.next = new Node(9);
        head1.next.next = new Node(9);

        Node head2 = new Node(1);

        printLinkedList(head1);
        printLinkedList(head2);
        printLinkedList(addLists1(head1, head2));
        printLinkedList(addLists2(head1, head2));

    }


}