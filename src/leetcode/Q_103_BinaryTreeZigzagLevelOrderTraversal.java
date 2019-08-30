package leetcode;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * jh
 * 2019年08月29日  10：04
 *
 * 二叉树的之字形遍历
 */
public class Q_103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode curLast = root;
        TreeNode nextLast = null;
        queue.offer(root);
        boolean lr = true;
        List<Integer> curList = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode cur = null;
            if(lr){
                cur = queue.pollLast();
                curList.add(cur.val);
                if(cur.left!=null){
                    queue.offerFirst(cur.left);
                    nextLast = nextLast == null? cur.left:nextLast;
                }
                if(cur.right!=null){
                    queue.offerFirst(cur.right);
                    nextLast = nextLast == null? cur.right:nextLast;
                }
            }else {
                cur = queue.pollFirst();
                curList.add(cur.val);
                if (cur.right!=null){
                    queue.offerLast(cur.right);
                    nextLast = nextLast == null?cur.right:nextLast;
                }
                if(cur.left!=null){
                    queue.offerLast(cur.left);
                    nextLast = nextLast == null? cur.left:nextLast;
                }
            }
            if(cur == curLast){
                curLast = nextLast;
                nextLast = null;
                lr = !lr;
                result.add(new ArrayList<>(curList));
                curList = new ArrayList<>();

            }

        }
        return result;







    }


















}