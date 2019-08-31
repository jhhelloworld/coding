package leetcode;

import com.sun.xml.internal.bind.v2.runtime.NameBuilder;
import util.TreeNode;

/**
 * jh
 * 2019年08月31日  15：28
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 */
public class Q_108_ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return build(nums,0,nums.length-1);
    }


    public TreeNode build(int[] nums,int begin,int end){
        if(begin>end){
            return null;
        }
        int mid = begin+(end-begin)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums,begin,mid-1);
        root.right = build(nums,mid+1,end);
        return root;
    }

}