package leetcode;

/**
 * jh
 * 2019年02月26日  16：49
 * [1,2,2,3,3,null,null,4,4]
 */
public class Q_110_BalancedBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if(getHeight(root)<=2){
            return true;
        }
        return (isBalanced(root.right)
                && isBalanced(root.left)
                && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1);

    }


    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(getHeight(root.left), getHeight(root.right))+1;
        }
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.left.left = new TreeNode(3);
        head.left.left.left = new TreeNode(4);
        head.right = new TreeNode(3);
        head.right.right = new TreeNode(4);
        System.out.println(getHeight(head));

        System.out.println(isBalanced(head));



    }


    /**
     *空间最低
     */
    class Solution {
        boolean status = true;
        public boolean isBalanced(TreeNode root) {

            if (root == null)
                return status;

            helper(root);

            return status;
        }


        public int helper(TreeNode root){
            if (root == null)
                return 0;

            int leftHeight = helper(root.left);
            int rightHeight = helper(root.right);
            if (Math.abs(leftHeight-rightHeight)>1){
                status = false;

            }

            return 1+Math.max(leftHeight,rightHeight);

        }

    }


    /**
     * 时间最低
     */
    class Solution1 {
        public boolean isBalanced(TreeNode root) {
            return helper(root) != -1;
        }

        private int helper(TreeNode node) {
            if (node == null) return 0;

            int left = helper(node.left);
            if (left == -1) return -1;
            int right = helper(node.right);
            if (right == -1) return -1;

            if (Math.abs(left - right) > 1) return -1;
            return Math.max(left, right) + 1;
        }
    }

}