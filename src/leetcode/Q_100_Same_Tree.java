package leetcode;

import sun.nio.cs.FastCharsetProvider;

/**
 * jh
 * 2019年03月06日  11：10
 *
 */
public class Q_100_Same_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        //前序遍历
        StringBuilder sp = preTree(p,new StringBuilder());
        StringBuilder sq = preTree(q,new StringBuilder());
        if(sp.toString().equals(sq.toString())){
            return true;
        }else {
            return false;
        }



    }

    public  StringBuilder preTree(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("#");
            return sb;
        }else {
            sb.append(root.val);
        }
        preTree(root.left,sb);
        preTree(root.right,sb);
        return sb;
    }
}

























