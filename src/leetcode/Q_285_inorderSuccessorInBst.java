package leetcode;

import util.TreeNode;

import java.util.Stack;

/**
 * jh
 * 2019年11月12日  13：35
 * 给你一个二叉搜索树和其中的某一个结点，请你找出该结点在树中顺序后继的节点。
 * 结点 p 的后继是值比 p.val 大的结点中键值最小的结点。
 */
public class Q_285_inorderSuccessorInBst {


    /**
     * 第一版,原理：存储上一个节点
     */
    TreeNode lastNode = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        TreeNode leftNode = inorderSuccessor(root.left, p);
        if (leftNode != null) {
            return leftNode;
        }
        if (lastNode != null && lastNode == p) {
            return root;
        }
        lastNode = root;
        return inorderSuccessor(root.right, p);
    }


    /**
     * 递归版
     * 改进：上面的做法忽略了这是一个二叉搜索树
     * 如果不是二叉搜索树，上面是一个很好的解法
     */
    public TreeNode inorderSuccessorV2(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        // 当前节点<=p,去右子树找，一直到当前节点比P大，为什么有等于：如果root为p,后续节点在右子树
        // 这样P的下一个节点可能是当点节点或者继续在左子树找
        if (root.val <= p.val) {
            return inorderSuccessorV2(root.right, p);
        } else {
            TreeNode left = inorderSuccessorV2(root.left, p);
            return (left != null) ? left : root;
        }
    }


    //非递归
    public TreeNode inorderSuccessorV3(TreeNode root, TreeNode p) {
        if (p == null) {
            return null;
        }
        // p节点有右子树，找到右子树的最左节点返回
        if (p.right != null) {
            return findSmallestOfNode(p.right);
        }
        //p的右子树为空，向上找父节点，一直到某个节点是他父节点的左子树
        //栈中存储当前节点的父节点
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            if (cur.val < p.val) {
                cur = cur.right;
            } else if (cur.val > p.val) {
                cur = cur.left;
            } else {
                break;
            }
        }
        cur = p;
        TreeNode parent = null;
        while (!stack.empty()) {
            parent = stack.pop();
            if (cur == parent.left) {
                return parent;
            }
            cur = parent;
        }
        return null;
    }

    private TreeNode findSmallestOfNode(TreeNode head) {
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }


    //如果有指向父节点的指针
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node inorderSuccessorV4(Node x) {
        if (x == null) {
            return null;
        }
        if (x.right != null) {
            return findSmallestOfNode(x.right);
        }
        Node parent = x.parent;
        //一直找到某个节点是父节点的左孩子
        while (parent != null && parent.left != x) {
            x = parent;
            parent = parent.parent;
        }
        return parent;


    }

    private Node findSmallestOfNode(Node head) {
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }


}