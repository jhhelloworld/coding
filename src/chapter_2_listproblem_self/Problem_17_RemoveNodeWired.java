package chapter_2_listproblem_self;

/**
 * @author Jianghua
 * 2018年10月26日  15：31
 */
public class Problem_17_RemoveNodeWired {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void removeNodeWired(Node node) {
        if(node == null){
            return;
        }
        Node next = node.next;
        if(node.next == null){

        }else {
            node.value = node.next.value;
            node.next = node.next.next;
        }
    }
}