package leetcode;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * jh
 * 2019年08月28日  23：47
 */
public class Q_102_BinaryTreeLevelOrderTraversal {
    //思路：存储当前层的下一层的最右节点，当遍历到下一层时，到达该层的最右节点时，切换下一层
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        //当前层的最右节点
        TreeNode curLast = root;
        //下一层的最右节点
        TreeNode nextLast = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        result.add(list);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            result.get(result.size()-1).add(cur.val);
            if(cur.left!=null){
                queue.offer(cur.left);
                nextLast = cur.left;
            }
            if(cur.right!=null){
                queue.offer(cur.right);
                nextLast = cur.right;
            }
            if(cur == curLast && !queue.isEmpty()){
                curLast = nextLast;
                nextLast = null;
                result.add(new ArrayList<>());
            }
        }
        // 如果没有上面的  !queue.isEmpty() 则需要下面一行删除最有一个空链表
        //result.remove(result.size()-1);

        return result;


    }
}


























