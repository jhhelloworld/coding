package leetcode;

import util.TreeNode;

/**
 * jh
 * 2019年08月27日  21：08
 *
 * 验证二叉搜索树
 *
 *
 */
public class Q_098_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return root == null || process(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }

    /**
     *
     * @param root 当前节点
     * @param maxValue  当前节点可能的最大值
     * @param minVlue 当前节点可能的最小值
     * @return
     */
    public boolean process(TreeNode root ,long maxValue,long minVlue){
        if(root == null){
            return true;
        }
        if(root.val>=maxValue || root.val<=minVlue){
            return false;
        }
        return process(root.left,root.val,minVlue) && process(root.right,maxValue,root.val);
    }




}