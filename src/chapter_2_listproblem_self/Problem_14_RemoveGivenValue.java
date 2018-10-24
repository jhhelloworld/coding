package chapter_2_listproblem_self;

/**
 * @author Jianghua
 * 2018年10月24日  17：04
 */
public class Problem_14_RemoveGivenValue {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node removeValue1(Node head, int num) {
        while (head !=null){
            if(head.value!=num){
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur!=null){
            if(cur.value == num){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;




    }
}