package leetcode;

import util.TreeNode;

/**
 * Author: jh
 * Date: 2020年04月01日  20:36
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class Q_543_diameterOfBinaryTree {


    /**
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     */


    /**
     * 思路：
     *  以某个节点的最大直径 = 左子树直径+右子树直径+1
     *  同时应该记录经过这个节点的最大直径 = math,max(左子树直径,右子树直径)+1
     *
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        process(root);
        return result-1;
    }


    private int result;

    public int process(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = process(root.left);
        int right = process(root.right);
        result = Math.max(result,left+right+1);

        return Math.max(left,right)+1;

    }



}























