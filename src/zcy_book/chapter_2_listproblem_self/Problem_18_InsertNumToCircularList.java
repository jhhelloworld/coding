package zcy_book.chapter_2_listproblem_self;

/**
 * @author Jianghua
 * 2018年10月26日  17：01
 */
public class Problem_18_InsertNumToCircularList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node insertNum(Node head, int num) {
       Node node = new Node(num);
       if(head == null){
           node.next = node;
           return node;
       }
       Node pre = head;
       Node cur = head.next;
       while (cur !=head){
           if(pre.value<=num && cur.value>=num){
               break;
           }
           pre = cur;
           cur = cur.next;
       }

       //todo 不能放在break前面，如果 永远不满足if条件，会导致新的节点插不进去
        pre.next = node;
        node.next = cur;

       head = head.value<num ? head:node;

        return head;
    }


    public static void printCircularList(Node head) {
        if (head == null) {
            return;
        }
        System.out.print("Circular List: " + head.value + " ");
        Node cur = head.next;
        while (cur != head) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println("-> " + head.value);
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertNum(head, 2);
        printCircularList(head);
        head = insertNum(head, 1);
        printCircularList(head);
        head = insertNum(head, 4);
        printCircularList(head);
        head = insertNum(head, 3);
        printCircularList(head);
        head = insertNum(head, 5);
        printCircularList(head);
        head = insertNum(head, 0);
        printCircularList(head);

    }

}