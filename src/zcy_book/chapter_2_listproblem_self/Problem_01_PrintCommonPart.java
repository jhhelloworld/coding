package zcy_book.chapter_2_listproblem_self;

/**
 * @author Jianghua
 * 2018年10月26日  19：24
 */
public class Problem_01_PrintCommonPart {
    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }

    public static void printCommonPart(Node head1, Node head2) {
        while (head1!= null && head2!=null){
            if(head1.value <head2.value){
                head1 = head1.next;
            }else if(head1.value > head2.value){
                head2 = head2.next;
            }else {
                System.out.println(head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }

    }
}