package chapter_3_binarytreeproblem_self;

import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;

import java.util.Stack;

/**
 * jh
 * 2018年10月27日  18：28
 */
public class Problem_01_PreInPosTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void preOrderRecur(Node head) {
        if(head == null){
            return;
        }
        System.out.println(head.value);
        preOrderRecur(head.left);
        preOrderRecur(head.right);


    }
    public static void inOrderRecur(Node head) {
        if(head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.value);
        inOrderRecur(head.right);

    }

    public static void posOrderRecur(Node head) {
        if(head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value);

    }

    public static void preOrderUnRecur(Node head) {
        System.out.println("pre:");
        if(head!=null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.empty()){
                head  = stack.pop();
                System.out.print(head.value+" ");
                if(head.right!=null){
                    stack.push(head.right);
                }
                if(head.left !=null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();




    }

    public static void inOrderUnRecur(Node head) {
        System.out.println("inorder:");
        if(head !=null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                }else {
                    head = stack.pop();
                    System.out.println(head.value+" ");
                    head = head.right;
                }
            }
        }
        System.out.println();


    }

    public static void posOrderUnRecur1(Node head) {
        System.out.println("pos-order");
        if(head!=null){
            Stack<Node> preStack = new Stack<>();
            Stack<Node> posStack = new Stack<>();
            while (!preStack.isEmpty()){
                head = preStack.pop();
                posStack.push(head);
                if(head.left!=null){
                    preStack.push(head.left);
                }
                if(head.right!=null){
                    preStack.push(head.right);
                }
            }
            while (!posStack.isEmpty()){
                System.out.print(posStack.pop()+" ");
            }

        }


    }

    public static void posOrderUnRecur2(Node h) {


    }



}
