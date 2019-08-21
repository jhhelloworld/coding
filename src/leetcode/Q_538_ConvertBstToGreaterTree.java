package leetcode;

import util.TreeNode;

/**
 * jh
 * 2019年08月15日  15：47
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 */
public class Q_538_ConvertBstToGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        if(root!=null){
            convertBST(root.left);
            root.val = 1;




            convertBST(root.right);
        }


        return root;


    }
}