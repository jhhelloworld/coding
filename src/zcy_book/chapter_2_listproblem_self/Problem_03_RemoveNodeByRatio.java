package zcy_book.chapter_2_listproblem_self;

/**
 * @author Jianghua
 * 2018年10月27日  11：00
 */
public class Problem_03_RemoveNodeByRatio {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node removeMidNode(Node head) {
        if(head == null || head.next == null ){
            return  head ;
        }
        if(head.next.next == null){
            return  head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while (cur != null && cur.next != null){
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;

        return head;
    }

    public static Node removeByRatio(Node head, int a, int b) {
        if(a<0 || a>b){
            return null;
        }
        int len = 0;
        Node cur = head;
        while (cur != null){
            len ++;
        }
        int preIndex = (int) Math.ceil( ((double)(len*a)/(double)b));
        if(preIndex == 1){
            head = head .next;
        }else {
            cur = head;
            while (--preIndex != 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }

        return head;
    }
}