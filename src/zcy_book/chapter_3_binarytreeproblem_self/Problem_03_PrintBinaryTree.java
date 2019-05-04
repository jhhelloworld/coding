package zcy_book.chapter_3_binarytreeproblem_self;

/**
 * @author Jianghua
 * 2018年10月30日  19：11
 */
public class Problem_03_PrintBinaryTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void printTree(Node head) {
        System.out.println("Starting...");
        printInOrder(head,0,"H",17);
        System.out.println();

    }
    public static void printInOrder(Node head,int height,String to,int len){
        if(head == null){
            return;
        }
        printInOrder(head.right,height+1,"v",len);
        String val = to+head.value+to;
        int lenM = val.length();
        int lenL = (len-lenM)/2;
        int lenR = len-lenL-lenM;
        val = getSpace(lenL)+val+getSpace(lenR);
        System.out.println(getSpace(len*height)+val);


        printInOrder(head.left,height+1,"^",len);

    }
    public static String getSpace(int num) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<num;i++){
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(-222222222);
        head.right = new Node(3);
        head.left.left = new Node(Integer.MIN_VALUE);
        head.right.left = new Node(55555555);
        head.right.right = new Node(66);
        head.left.left.right = new Node(777);
        printTree(head);

        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.left.left.right = new Node(7);
        printTree(head);

        head = new Node(1);
        head.left = new Node(1);
        head.right = new Node(1);
        head.left.left = new Node(1);
        head.right.left = new Node(1);
        head.right.right = new Node(1);
        head.left.left.right = new Node(1);
        printTree(head);

    }
}