package leetcode;

import util.TreeNode;

import java.util.Stack;

/**
 * jh
 * 2019年08月31日  14：32
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class Q_101_SymmetricTree {
    //递归
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSym(root.left,root.right);

    }

    public boolean isSym(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left!=null && right!=null && left.val == right.val){
            return isSym(left.left,right.right) && isSym(left.right,right.left);
        }else {
            return false;
        }
    }



    //非递归：
    public boolean isSymmetric2(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()){
            TreeNode n1 = stack.pop(),n2 = stack.pop();
            if(n1 == null && n2 == null){
                continue;
            }
            if(n1==null || n2==null || n1.val!=n2.val){
                return false;
            }
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }




}


















