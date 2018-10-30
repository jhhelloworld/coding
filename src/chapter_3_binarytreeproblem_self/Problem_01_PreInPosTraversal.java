package chapter_3_binarytreeproblem_self;

import chapter_8_arrayandmatrix.Problem_20_PrintMaxTopK;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.text.NumberFormat;
import java.util.Stack;

/**
 * @author Jianghua
 * 2018年10月30日  10：12
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
    public static void preOrderUnRecur(Node head) {
        System.out.print("preOrderUnRecur: ");
        if(head!=null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value+" ");
                if(head.right!=null){
                    stack.push(head.right);
                }
                if(head.left!=null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public static void inOrderUnRecur(Node head) {
        System.out.print("inOrderUnRecur: ");
        if(head!=null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head!=null){
                if(head!=null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.print(head.value+" ");
                    head = head.right;
                }
            }
            System.out.println();
        }
    }

    public static void posOrderUnRecur1(Node head) {
        System.out.print("posOrderUnRecur1:");
        if(head!=null){
            Stack<Node> preStack = new Stack();
            Stack<Node> posStack = new Stack();
            preStack.push(head);
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
                System.out.print(posStack.pop().value+" ");
            }

        }
    }

    public static void posOrderUnRecur2(Node h) {
        System.out.println("posOrderUnRecur2");
        if(h!=null){
            Stack<Node> stack = new Stack<>();
            stack.push(h);
            Node c=  null;
            while (!stack.isEmpty()){
                c = stack.peek();
                if(h.left!=null && h.left != c && h.right != c){
                    stack.push(h.left);
                }else if(h.right !=null && h.right!= c){
                    stack.push(h.right);
                }else {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
            System.out.println();
        }

    }








}


























