package basic.binarytree;

import com.sun.tools.internal.ws.processor.generator.CustomExceptionGenerator;
import zcy_lesson.code_08.Test;

import java.util.Stack;

/**
 * jh
 * 2019年05月09日  14：43
 * 二叉树练习
 */
public class Practice {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 给定一个二叉查找树(什么是二叉查找树)，以及一个节点，求该节点在中序遍历的后继，如果没有则返回null
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p==null){
            return null;
        }

        // p节点有右子树，找到右子树的最左节点返回
        if(p.right!=null){
            return findSmallestOfNode(p.right);
        }
        //p的右子树为空，向上找父节点，一直到某个节点是他父节点的左子树
        //栈中存储当前节点的父节点
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null){
            stack.push(cur);
            if(cur.val < p.val){
                cur = cur.right;
            }else if(cur.val>p.val){
                cur = cur.left;
            }else {
                break;
            }
        }
        cur = p;
        TreeNode parent = null;
        while (!stack.empty()){
            parent = stack.pop();
            if(cur == parent.left){
                return parent;
            }else {
                cur = parent;
            }
        }
        return null;
    }

    private static TreeNode findSmallestOfNode(TreeNode head){
        while (head!=null && head.left!=null){
            head = head.left;
        }
        return head;
    }


    /**
     * 递归版
     */
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        if (root.val <= p.val) {
            return inorderSuccessor2(root.right, p);
        } else {
            TreeNode left = inorderSuccessor2(root.left, p);
            return (left != null) ? left : root;
        }
    }












    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        head.right = node;
        System.out.println(inorderSuccessor(head,head).val);
        String s = "";
        char[] arr = s.toCharArray();
    }

}


























