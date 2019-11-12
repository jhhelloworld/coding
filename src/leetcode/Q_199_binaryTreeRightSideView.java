package leetcode;

import util.ListNode;
import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * jh
 * 2019年11月12日  19：26
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class Q_199_binaryTreeRightSideView {

    /**
     * 非递归，和逐层遍历相似，主要是记录每一层的最右节点
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curLevel = 1;
        int nextLevel = 0;
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            for (int i = 0; i < curLevel; i++) {
                cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                    nextLevel++;
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    nextLevel++;
                }
            }
            result.add(cur.val);
            curLevel = nextLevel;
            nextLevel = 0;
        }
        return result;
    }


    /**
     * 递归
     */
    public List<Integer> rightSideViewV2(TreeNode root) {
        List<Integer> reuslt = new ArrayList<>();
        process(root, 0, reuslt);
        return reuslt;
    }

    public void process(TreeNode root, int n, List<Integer> result) {
        if (root == null) {
            return;
        }
        //二者相等，则说明当面节点是这一层的第一个
        if (n == result.size()) {
            result.add(root.val);
        }
        //先放入右节点，很重要
        if (root.right != null) {
            process(root.right, n + 1, result);
        }
        if (root.left != null) {
            process(root.left, n + 1, result);
        }
    }
}





















