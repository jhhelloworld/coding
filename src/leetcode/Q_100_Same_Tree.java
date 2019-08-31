package leetcode;

import sun.nio.cs.FastCharsetProvider;
import util.TreeNode;

/**
 * jh
 * 2019年03月06日  11：10
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class Q_100_Same_Tree {


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


    //优化
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p==null && q == null){
            return true;
        }
        if(p!=null && q!=null && p.val == q.val){
            return isSameTree2(p.left,q.left) && isSameTree2(p.right,q.right);
        }else {
            return false;
        }

    }
}

























